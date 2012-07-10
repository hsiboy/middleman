package middleman.proxy;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import middleman.api.MiddlemanController;
import middleman.configuration.ProxyConfig;
import middleman.framework.WebServer;
import middleman.logging.ApplicationLog;
import middleman.logging.RequestLogger;
import middleman.server.ProxyConfigurationHttpHandler;
import middleman.utils.Utils;

import com.sun.net.httpserver.HttpServer;

public class ProxyServer extends Thread implements WebServer {

    public static final int DEFAULT_PORT = 8080;
    private static List<ProxyServer> proxies = new ArrayList<ProxyServer>();
    private ServerSocket server = null;
    private int proxyPort = DEFAULT_PORT;
    private final ProxyConfig proxyConfig;
    private ApplicationLog applicationLog;
    private final RequestLogger requestLogger = new RequestLogger();
    private final AtomicLong requestId = new AtomicLong(0);
    private boolean canceled = false;
    private volatile RequestFilter proxyRequestFilter;

    public static ProxyServer startProxy(ApplicationLog applicationLog, ProxyConfig proxyConfig, MiddlemanController middlemanController) {
        ProxyServer proxyServer = new ProxyServer(proxyConfig.getPort(), proxyConfig, applicationLog);
        middlemanController.control(proxyServer);
        proxyServer.start();

        applicationLog.log("Proxy server " + proxyConfig.getName() + " started");

        proxies.add(proxyServer);
        return proxyServer;
    }

    public static void stopProxy(ProxyConfig proxyConfig) {
        for (ProxyServer proxy : proxies) {
              if (proxyConfig.getName().equals(proxy.getName())) {
                  proxy.cancel();
            }
        }
    }

    public static ProxyServer getProxy(String proxyName) {
        for (ProxyServer proxy : proxies) {
            if (proxy.getName().equals(proxyName)) {
                return proxy;
            }
        }

        throw new RuntimeException("Proxy not found");
    }

    public synchronized void cancel() {
        if (!canceled) {
            canceled = true;
            closeSocket();
        }
    }

    public synchronized boolean isCanceled() {
        return canceled;
    }

    protected ProxyServer(int port, ProxyConfig proxyConfig, ApplicationLog applicationLog) {
        this.proxyPort = port;
        this.proxyConfig = proxyConfig;
        this.applicationLog = applicationLog;
        this.setName(proxyConfig.getName());
    }

    public void closeSocket() {
        Utils.close(server);
        server = null;
    }

    @Override
    public void run() {
        try {
            server = new ServerSocket(proxyPort);
            applicationLog.log("Started Proxy server on port " + proxyPort);

            while (!isCanceled()) {
                Socket client = server.accept();
                ProxyChannel t = new ProxyChannel(client, proxyConfig, requestLogger, applicationLog, proxyRequestFilter);
                t.start();
            }
        } catch (Exception e) {
            applicationLog.log("ProxyServer Thread error: ", e);
        } finally {
            closeSocket();
        }
    }

    public void createContext(HttpServer server) {
        server.createContext("/" + proxyConfig.getName(), new ProxyConfigurationHttpHandler(this));
    }

    public ProxyConfig getConfig() {
        return proxyConfig;
    }

    public List<ProxyConfig> getRunningProxies() {
        return new ArrayList<ProxyConfig>();
    }

    public void startNewProxy(String name, int port) {
        throw new UnsupportedOperationException("Cannot create a new proxy on an existing proxy");
    }

    public RequestLogger getLogs() {
        return requestLogger;
    }

    public void setProxyRequestFilter(RequestFilter requestFilter) {
        this.proxyRequestFilter = requestFilter;
    }
}
