package middleman.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import static middleman.server.UriMatchers.pathMatcher;
import middleman.server.components.*;
import middleman.proxy.ProxyServer;

public class ProxyConfigurationHttpHandler implements HttpHandler {
    private ProxyServer proxyServer;

    public ProxyConfigurationHttpHandler(ProxyServer proxyServer) {
        this.proxyServer = proxyServer;
    }

    public void handle(HttpExchange httpExchange) {
        try {
            String method = httpExchange.getRequestMethod();

            // This is created in the wrong place
            Dispatcher dispatcher = new Dispatcher();
            dispatcher.register(pathMatcher(proxyServer.getConfig().getName()), new ProxyConfigurationPresenter());
            dispatcher.register(pathMatcher(proxyServer.getConfig().getName(), "stub", "new"), new NewStubCommand());
            dispatcher.register(pathMatcher(proxyServer.getConfig().getName(), "log"), new ProxyLogPresenter(proxyServer.getLogs()));
            dispatcher.register(pathMatcher(proxyServer.getConfig().getName(), "log", "csv"), new ProxyLogCSVPresenter(proxyServer.getLogs()));
            dispatcher.register(pathMatcher(proxyServer.getConfig().getName(), "log", "xml"), new ProxyLogXMLPresenter(proxyServer.getLogs()));
            dispatcher.register(pathMatcher(proxyServer.getConfig().getName(), "log", "json"), new ProxyLogJSONPresenter(proxyServer.getLogs(), false));
            dispatcher.register(pathMatcher(proxyServer.getConfig().getName(), "log", "jsonp"), new ProxyLogJSONPresenter(proxyServer.getLogs(), true));
            dispatcher.register(pathMatcher(proxyServer.getConfig().getName(), "log", "reset"), new ResetProxyLogCommand(proxyServer.getLogs()));

            if (method.equalsIgnoreCase("GET")) {
                dispatcher.dispatchGetRequest(new WebContext(proxyServer, httpExchange));
            }

            if (method.equalsIgnoreCase("POST")) {
                dispatcher.dispatchPostRequest(new WebContext(proxyServer, httpExchange));
            }

        } catch (Exception e) {
            System.err.println("Error executing request");
            e.printStackTrace();
        }
    }
}
