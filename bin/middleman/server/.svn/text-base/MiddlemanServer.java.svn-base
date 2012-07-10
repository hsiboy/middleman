package middleman.server;

import static middleman.server.UriMatchers.simpleMatcher;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import middleman.api.MiddlemanApi;
import middleman.api.MiddlemanController;
import middleman.configuration.MiddlemanConfiguration;
import middleman.configuration.ProxyConfig;
import middleman.framework.Command;
import middleman.framework.WebServer;
import middleman.logging.ApplicationLog;
import middleman.model.RequestLogEntry;
import middleman.proxy.ProxyServer;
import middleman.server.components.ClasspathContentPresenter;
import middleman.server.components.HomePagePresenter;
import middleman.server.components.NewProxyCommand;
import middleman.server.components.NewProxyPresenter;
import middleman.utils.Block;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


// OK this one needs to use string template too
public class MiddlemanServer implements HttpHandler, WebServer {
	HttpServer server;
	private MiddlemanConfiguration configuration;
	private ApplicationLog applicationLog;
	private MiddlemanController controller = new MiddlemanController();

	public MiddlemanServer(ApplicationLog applicationLog) {
		this.applicationLog = applicationLog;
	}

	public void start(MiddlemanConfiguration configuration) {
		try {
			this.configuration = configuration;
			applicationLog.log("Starting configuration server on port " + configuration.getConfigurationPort());
			server = HttpServer.create(new InetSocketAddress(configuration.getConfigurationPort()), 0);
			server.createContext("/", this);
			server.setExecutor(null);
			server.start();

			controller.setConfiguration(configuration);

			startProxyServers(configuration);
		} catch (IOException e) {
			throw new RuntimeException("Failed to start middleman server ", e);
		}
	}


	private void startProxyServers(MiddlemanConfiguration configuration) {
		configuration.eachProxy(new Block<ProxyConfig>() {
			public void yield(ProxyConfig item) {
				applicationLog.trace("Starting proxy server " + item.getName());

				ProxyServer proxy = ProxyServer.startProxy(applicationLog, item, controller);
				proxy.createContext(server);
			}
		});
	}

	private void stopProxyServers(MiddlemanConfiguration configuration) {
		configuration.eachProxy(new Block<ProxyConfig>() {
			public void yield(ProxyConfig item) {
				applicationLog.trace("Stopping proxy server " + item.getName());

				ProxyServer.stopProxy(item);
			}
		});
	}

	public void handle(HttpExchange httpExchange) {
		try {
			String method = httpExchange.getRequestMethod();

			Dispatcher dispatcher = new Dispatcher();
			dispatcher.register(simpleMatcher("/"), new HomePagePresenter(configuration));
			dispatcher.register(simpleMatcher("/proxy/new"), new NewProxyPresenter(), new NewProxyCommand());
			dispatcher.register(UriMatchers.classpathMatcher(), new ClasspathContentPresenter());
			dispatcher.register(simpleMatcher("/stop"), new Command() {
				public void executeCommand(WebContext context) {
					stop();
				}
			});

			if (method.equalsIgnoreCase("GET")) {
				dispatcher.dispatchGetRequest(new WebContext(this, httpExchange));
			}

			if (method.equalsIgnoreCase("POST")) {
				dispatcher.dispatchPostRequest(new WebContext(this, httpExchange));
			}
		} catch (NoRouteException nre) {
			send404(httpExchange);
		}
		catch (Exception e) {
			send404(httpExchange);
			System.err.println("Error processing request");
			e.printStackTrace();
		}
	}

	public void stop() {
		stopProxyServers(configuration);
		server.stop(0);
	}

	private void send404(HttpExchange httpExchange) {
		try {
			httpExchange.sendResponseHeaders(404, -1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ProxyConfig getConfig() {
		return null;
	}

	public List<ProxyConfig> getRunningProxies() {
		final List<ProxyConfig> proxies = new ArrayList<ProxyConfig>();
		configuration.eachProxy(new Block<ProxyConfig>() {
			public void yield(ProxyConfig item) {
				proxies.add(item);
			}
		});
		return proxies;
	}

	public void startNewProxy(String name, int port) {
		ProxyConfig proxyConfig = new ProxyConfig();
		proxyConfig.setName(name);
		proxyConfig.setPort(port);
		configuration.add(proxyConfig);
		ProxyServer proxy = ProxyServer.startProxy(applicationLog, proxyConfig, controller);
		proxy.createContext(server);
	}


	public String uri(String path) {
		return "http://localhost:" + configuration.getConfigurationPort() + path;
	}

	public MiddlemanApi api() {
		return controller;
	}

	public Iterable<RequestLogEntry> getLogsFor(String proxyName) {
		return ProxyServer.getProxy(proxyName).getLogs().getEntries();
	}

	public void clearLogsFor(String proxyName) {
		ProxyServer.getProxy(proxyName).getLogs().clear();
	}
}
