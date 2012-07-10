package middleman.proxy;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import middleman.configuration.ProxyConfig;
import middleman.logging.ApplicationLog;
import static org.hamcrest.CoreMatchers.any;
import org.junit.Test;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ProxyServerUnitTests {

    @Test
    public void proxyServerCreatesContextOnGivenServer() {
        ProxyConfig config = new ProxyConfig();
        config.setName("foo");
        ProxyServer proxy = new ProxyServer(0, config, mock(ApplicationLog.class));
        HttpServer server = mock(HttpServer.class);
        proxy.createContext(server);

        verify(server).createContext(eq("/foo"), argThat(any(HttpHandler.class)));
    }

}