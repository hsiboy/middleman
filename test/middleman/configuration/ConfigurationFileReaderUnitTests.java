package middleman.configuration;

import middleman.framework.UriMatcher;
import middleman.logging.ApplicationLog;
import middleman.utils.Block;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ConfigurationFileReaderUnitTests {
    @Test
    public void canConfigureMiddlemanPort() {
        InputStream i = createInputStreamFor("port=2001");

        ConfigurationFileReader reader = new ConfigurationFileReader(mock(ApplicationLog.class));
        MiddlemanConfiguration config = new MiddlemanConfiguration(mock(ApplicationLog.class));
        reader.readConfiguration(i, config);

        assertThat(config.getConfigurationPort(), equalTo(2001));
    }
    
    @Test
    public void canConfigureMiddlemanPort80() {
        InputStream i = createInputStreamFor("port=80");

        ConfigurationFileReader reader = new ConfigurationFileReader(mock(ApplicationLog.class));
        MiddlemanConfiguration config = new MiddlemanConfiguration(mock(ApplicationLog.class));
        reader.readConfiguration(i, config);

        assertThat(config.getConfigurationPort(), equalTo(80));
    }
    
    @Test
    public void readerAcceptsRouteForProxyWithDash() {
        String basicProxyDefn = "proxy foo-bar { " +
                "}";
        InputStream i = createInputStreamFor(basicProxyDefn);

        ConfigurationFileReader reader = new ConfigurationFileReader(mock(ApplicationLog.class));
        MiddlemanConfiguration config = new MiddlemanConfiguration(mock(ApplicationLog.class));
        reader.readConfiguration(i, config);

        assertThat(config.hasProxy("foo-bar"), is(true));
    }
    
    @Test
    public void readerAcceptsRouteForProxy() {
        String basicProxyDefn = "proxy foobar {\n" +
                "}";
        InputStream i = createInputStreamFor(basicProxyDefn);

        ConfigurationFileReader reader = new ConfigurationFileReader(mock(ApplicationLog.class));
        MiddlemanConfiguration config = new MiddlemanConfiguration(mock(ApplicationLog.class));
        reader.readConfiguration(i, config);

        assertThat(config.hasProxy("foobar"), is(true));
    }
    
    
    @Test
    public void readerAcceptsRouteForProxyWithNumber() {
        String basicProxyDefn = "proxy foobar2 {\n" +
                "}";
        InputStream i = createInputStreamFor(basicProxyDefn);

        ConfigurationFileReader reader = new ConfigurationFileReader(mock(ApplicationLog.class));
        MiddlemanConfiguration config = new MiddlemanConfiguration(mock(ApplicationLog.class));
        reader.readConfiguration(i, config);

        assertThat(config.hasProxy("foobar2"), is(true));
    }
    
    @Test
    public void readerAcceptsRouteForProxyWithNumberAndDash() {
        String basicProxyDefn = "proxy foo-bar2 { " +
                "}";
        InputStream i = createInputStreamFor(basicProxyDefn);

        ConfigurationFileReader reader = new ConfigurationFileReader(mock(ApplicationLog.class));
        MiddlemanConfiguration config = new MiddlemanConfiguration(mock(ApplicationLog.class));
        reader.readConfiguration(i, config);

        assertThat(config.hasProxy("foo-bar2"), is(true));
    }
    

    @Test
    public void readerParsesProxyAttributes() {
        InputStream i = createInputStreamFor("proxy foo_bar {\n" +
                "port = 8080\n" +
                // "route \"www.from.com\" => \"www.to.com\"\n" +
                "outgoing-proxy = \"http://proxy.corp.com:8080\"\n" +
                "debug = 1\n" +
                "}");

        ConfigurationFileReader reader = new ConfigurationFileReader(mock(ApplicationLog.class));
        MiddlemanConfiguration config = new MiddlemanConfiguration(mock(ApplicationLog.class));
        reader.readConfiguration(i, config);

        assertThat(config.hasProxy("foo_bar"), is(true));
    }

    @Test
    public void shouldParseAPreciseIPAddress() {
        ConfigurationFileReader reader = new ConfigurationFileReader(mock(ApplicationLog.class));
        MiddlemanConfiguration config = new MiddlemanConfiguration(mock(ApplicationLog.class));

        String basicProxyDefn = "proxy foo-bar_2 {\n" +
                "   stub 127.13.213.455 {\n" +
                "      status-code = 200\n" +
                "      body = [X]\n" +
                "   }\n" +
                "}";

        reader.readConfiguration(createInputStreamFor(basicProxyDefn), config);
        assertThat(findAllStubsMatching(config, "127.13.213.455").size(), is(1));
        assertThat(findAllStubsMatching(config, "127.131.213.455").size(), is(0));
    }

    @Test
    public void readerParsesStubDefinitions() {
        String basicProxyDefn = "proxy foo2_-bar { " +
                "   stub foo.com {\n" +
                "      status-code = 200\n" +
                "      header = [Cache-Control:no-cache]\n"+
                "      body = [X]\n" +
                "   }\n" +
                "}";

        ConfigurationFileReader reader = new ConfigurationFileReader(mock(ApplicationLog.class));
        MiddlemanConfiguration config = new MiddlemanConfiguration(mock(ApplicationLog.class));
        reader.readConfiguration(createInputStreamFor(basicProxyDefn), config);

        assertThat(config.hasProxy("foo2_-bar"), is(true));

        List<StubResponse> found = findAllStubsMatching(config, "foo.com");

        assertThat(found.size(), is(1));
        assertThat(found.get(0).getBody(), is("X"));
        //assertThat(found.get(0).getHeader(), is("X"));
        assertThat(found.get(0).getStatusCode(), is("200"));
    }

    @Test
    public void shouldParseBodyDataWithNestedSquareBrackets() {
        String basicProxyDefn = "proxy foobar { " +
                "   stub foo.com {\n" +
                "      status-code=200\n" +
                "      body = [[Hello [World]]]\n" +
                "   }\n" +
                "}";

        ConfigurationFileReader reader = new ConfigurationFileReader(mock(ApplicationLog.class));
        MiddlemanConfiguration config = new MiddlemanConfiguration(mock(ApplicationLog.class));
        reader.readConfiguration(createInputStreamFor(basicProxyDefn), config);

        assertThat(config.hasProxy("foobar"), is(true));

        List<StubResponse> found = findAllStubsMatching(config, "foo.com");

        assertThat(found.size(), is(1));
        assertThat(found.get(0).getBody(), is("[Hello [World]]"));
        assertThat(found.get(0).getStatusCode(), is("200"));
    }

    private List<StubResponse> findAllStubsMatching(MiddlemanConfiguration config, final String hostname) {
        final List<StubResponse> found = new ArrayList<StubResponse>();
        Block<ProxyConfig> visitor = new Block<ProxyConfig>() {
            public void yield(ProxyConfig item) {
                for (UriMatcher matcher : item.getStubs().keySet()) {
                    if (matcher.matches(URI.create(hostname))) {
                        found.add(item.getStubs().get(matcher));
                    }
                }
            }
        };

        config.eachProxy(visitor);
        return found;
    }

    private InputStream createInputStreamFor(String configuration) {
        return new ByteArrayInputStream(configuration.getBytes());
    }
}
