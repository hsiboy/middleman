package middleman.configuration;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;
import java.util.Map;

import middleman.framework.UriMatcher;
import middleman.server.components.StubRequest;

public class ProxyConfig {
	private int port;
	private String name;
	private Map<UriMatcher, StubResponse> stubs;
	private URI outgoingProxy;
	private int debugLevel;

	public ProxyConfig() {
		this.name = "undefined";
		this.stubs = new LinkedHashMap<UriMatcher, StubResponse>();
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void createOrUpdateStub(StubRequest stubRequest) {
		stubRequest.define(stubs);
	}

	public String getOutgoingProxyHost() {
		if (outgoingProxy == null) {
			return "";
		}
		return outgoingProxy.getHost();
	}

	public int getOutgoingProxyPort() {
		if (outgoingProxy == null) {
			return 80;
		}
		return outgoingProxy.getPort();
	}


	public boolean hasOutgoingProxyFor(String hostname) {
		return outgoingProxy != null && !isLocalhost(hostname);
	}

	
	public boolean isLocalhost(String hostname) {
		java.net.InetAddress localMachine;
		try {
			localMachine = java.net.InetAddress.getLocalHost();
			if (hostname.equalsIgnoreCase(localMachine.getHostName()) ||
					hostname.equalsIgnoreCase(localMachine.getHostAddress()) ||
					hostname.equalsIgnoreCase("0.0.0.0") ||
					hostname.equalsIgnoreCase("127.0.0.1") ||
					hostname.equalsIgnoreCase("localhost") ||
					localMachine.isLoopbackAddress()) {
				return true;
			}
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}

		return false;
	}

	public int getDebugLevel() {
		return debugLevel;
	}

	public boolean stubbedRequest(String hostName) {
		for (UriMatcher matcher : stubs.keySet()) {
			try {
				if (matcher.matches(new URI(hostName))) {
					return true;
				}
			} catch (URISyntaxException e) {
				throw new RuntimeException(e);
			}
		}
		return false;
	}

	public StubResponse getStubbedResponse(String hostName) {
		for (UriMatcher matcher : stubs.keySet()) {
			try {
				if (matcher.matches(new URI(hostName))) {
					return stubs.get(matcher);
				}
			} catch (URISyntaxException e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}

	public Map<UriMatcher, StubResponse> getStubs() {
		return stubs;
	}

	public void setOutgoingProxy(String outgoingProxy) {
		this.outgoingProxy = URI.create(outgoingProxy.replaceAll("\"", ""));
	}

	public void setDebugLevel(int debugLevel) {
		this.debugLevel = debugLevel;
	}

	public void add(StubResponse stubResponse) {
		stubs.put(stubResponse.getPath(), stubResponse);
	}

	public void addToStubsAsFirst(StubResponse stubResponse) {
		Map<UriMatcher, StubResponse> tempStubs = new LinkedHashMap<UriMatcher, StubResponse>();
		tempStubs.put(stubResponse.getPath(), stubResponse);
		tempStubs.putAll(stubs);
		stubs=tempStubs;
	}

	public long getDelayForHost(String hostname) {
		StubResponse stubResponse = getStubbedResponse(hostname);

		return stubResponse == null ? 0 : stubResponse.getDelayInMillis();
	}





}
