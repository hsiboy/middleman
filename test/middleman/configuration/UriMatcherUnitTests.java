package middleman.configuration;

import middleman.framework.UriMatcher;
import middleman.server.UriMatchers;
import static middleman.server.UriMatchers.pathMatcher;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

public class UriMatcherUnitTests {
    @Test
    public void simpleMatcherMatchesSimpleRoot() throws URISyntaxException {
        UriMatcher matcher = UriMatchers.simpleMatcher("/");

        assertThat(matcher.matches(new URI("/")), is(true));
        assertThat(matcher.matches(new URI("/home")), is(false));
    }

    @Test
    public void simpleMatcherMatchesSimplePaths() throws URISyntaxException {
        UriMatcher matcher = UriMatchers.simpleMatcher("/proxy/new");

        assertThat(matcher.matches(new URI("/proxy/new")), is(true));
        assertThat(matcher.matches(new URI("/proxy/new/")), is(true));
        assertThat(matcher.matches(new URI("/proxy/new//")), is(false));
    }
    
    @Test
    public void pathMatcherMatchesSimplePaths() throws URISyntaxException {
        UriMatcher matcher = UriMatchers.pathMatcher("proxy", "log", "xml");

        assertThat(matcher.matches(new URI("/proxy/log/xml")), is(true));
        assertThat(matcher.matches(new URI("/proxy/log/xml/")), is(true));
    }

    @Test
    public void patternMatcherMatchesWildcardPaths() throws URISyntaxException {
        UriMatcher matcher = UriMatchers.patternMatcher("^((?!localhost).)*$");
                                                         
        assertThat(matcher.matches(new URI("localhost")), is(false));
        assertThat(matcher.matches(new URI("stupot.taylor.org")), is(true));
    }

    @Test
    public void doesntMatchMultipleSpecifiedHosts() throws URISyntaxException {
        UriMatcher matcher = UriMatchers.patternMatcher("^((?!localhost)(?!toms.cabin.net).)*$");

        assertThat(matcher.matches(new URI("localhost")), is(false));
        assertThat(matcher.matches(new URI("toms.cabin.net/logging")), is(false));
        assertThat(matcher.matches(new URI("172.27.137.217")), is(true));
    }


    @Test
    public void doesntMatchIpAddress() throws URISyntaxException {
        UriMatcher matcher = UriMatchers.patternMatcher("^((?!172\\.27\\.137\\.217).)*$");

        assertThat(matcher.matches(new URI("172.27.137.217")), is(false));
        assertThat(matcher.matches(new URI("172a27b137c217")), is(true));
    }

    @Test
    public void canExcludeAddressesWithPorts() throws URISyntaxException {
        UriMatcher matcher = UriMatchers.patternMatcher("^((?!localhost:8080).)*$");

        assertThat(matcher.matches(new URI("localhost:8080")), is(false));
        assertThat(matcher.matches(new URI("localhost")), is(true));
    }


}
