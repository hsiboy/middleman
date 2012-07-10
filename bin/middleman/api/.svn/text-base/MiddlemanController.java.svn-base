package middleman.api;

import static java.util.Collections.synchronizedList;

import java.util.ArrayList;
import java.util.List;

import middleman.configuration.MiddlemanConfiguration;
import middleman.configuration.ProxyConfig;
import middleman.configuration.StubResponse;
import middleman.proxy.HTTPRequest;
import middleman.proxy.ProxyServer;
import middleman.proxy.RequestFilter;
import middleman.server.UriMatchers;



public class MiddlemanController implements MiddlemanApi {

	private List<RequestModifier> modifiers = synchronizedList(new ArrayList<RequestModifier>());
	private RequestModificationFilter requestFilter = new RequestModificationFilter();
	private MiddlemanConfiguration configuration;
	private ProxyConfig proxyConfig;


	private final class RequestModificationFilter implements RequestFilter {
		@Override
		public void filterRequest(HTTPRequest request) {
			for (RequestModifier modifier : modifiers) {
				modifier.modifyRequest(request);
			}
		}
	}

	public RequestModifier addRequestModifier() {
		RequestModifier newModifier = new RequestModifier();
		modifiers.add(newModifier);
		return newModifier;
	}

	public void control(ProxyServer proxy) {
		proxy.setProxyRequestFilter(requestFilter);
	}

	public void clearRequestModifiers() {
		modifiers.clear();
	}

	@Override
	public void createStub(String proxyName, String host, String responseCode, byte[] header,
			byte[] body, long delayInMillis) {
		StubResponse stubResponse = new StubResponse(UriMatchers.simpleMatcher(host), new String(body), delayInMillis);
		stubResponse.setHeader(new String(header));
		stubResponse.setStatusCode(responseCode);

		if (configuration.hasProxy(proxyName)) {
			proxyConfig = configuration.getProxyByName(proxyName);
			proxyConfig.addToStubsAsFirst(stubResponse);
		}
	}

	public void setConfiguration(MiddlemanConfiguration configuration) {
		this.configuration=configuration;
	}

	public ProxyConfig getProxyConfig() {
		return proxyConfig;
	}

	public void setProxyConfig(ProxyConfig proxyConfig) {
		this.proxyConfig = proxyConfig;
	}


}
