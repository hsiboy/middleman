package middleman.proxy;

import static junit.framework.Assert.fail;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


public class DummyHttpServer {

	private List<ReceivedRequest> allReceivedRequests = Collections.synchronizedList(new ArrayList<ReceivedRequest>());
	private final int proxiedServerPort;

	public DummyHttpServer(int proxiedServerPort) {
		this.proxiedServerPort = proxiedServerPort;
	}

	public DummyHttpServer start() {
		HttpServer proxiedServer = null;
		try {
			proxiedServer = HttpServer.create(new InetSocketAddress(proxiedServerPort), 0);
		} catch (IOException e) {
			e.printStackTrace();
			fail("Couldn't start proxied server");
		}

		proxiedServer.createContext("/", new HttpHandler() {
			@Override
			public void handle(HttpExchange httpExchange) throws IOException {
				System.out.println(this.getClass() + " - Received requestFromMiddleman: " + httpExchange.getRequestURI());

				Headers receivedRequestHeaders = new Headers();
				receivedRequestHeaders.putAll(httpExchange.getRequestHeaders());

				allReceivedRequests.add(new ReceivedRequest(httpExchange.getRequestURI(), receivedRequestHeaders));
				respondWithOk(httpExchange);
			}

		});
		proxiedServer.setExecutor(null);
		proxiedServer.start();
		return this;
	}

	public List<ReceivedRequest> receivedRequests() {
		return allReceivedRequests;
	}

	private static void respondWithOk(HttpExchange httpExchange) throws IOException {
		byte [] response = "OK".getBytes();
		httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.length);
		httpExchange.getResponseBody().write(response);
		httpExchange.getResponseBody().flush();
	}

	public static class ReceivedRequest {
		private final URI uri;
		private final Headers headers;

		public ReceivedRequest(URI uri, Headers headers) {
			this.uri = uri;
			this.headers = headers;
		}

		public Headers getHeaders() {
			return headers;
		}

		public String getUrl() {
			return uri.toString();
		}
	}
}
