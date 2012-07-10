package middleman.framework;

import middleman.configuration.ProxyConfig;

import java.util.List;

public interface WebServer {
    ProxyConfig getConfig();

    List<ProxyConfig> getRunningProxies();

    void startNewProxy(String name, int port);
}
