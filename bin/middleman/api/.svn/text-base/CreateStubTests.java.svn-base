package middleman.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import middleman.configuration.MiddlemanConfiguration;
import middleman.configuration.ProxyConfig;
import middleman.configuration.StubResponse;
import middleman.proxy.HTTPRequest;
import middleman.proxy.ProxyServer;
import middleman.server.UriMatchers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class CreateStubTests {


	@Mock ProxyServer proxy;
	@Mock HTTPRequest request;
	MiddlemanController middlemanApi = new MiddlemanController();
	@Mock MiddlemanConfiguration middlemanconfiguration;

	@Before
	public void setUp() {
		initMocks(this);
	}


	@Test
	public void whenApiIsUsedToCreateStubThenTheStubIsAddedToProxyConfigStubs() {
		middlemanApi.control(proxy);
		long delayInMillis=1001;
		StubResponse stubResponse1 = new StubResponse(UriMatchers.simpleMatcher("www.test1.com"), "", delayInMillis);
		StubResponse stubResponse2 = new StubResponse(UriMatchers.simpleMatcher("www.test2.com"), "", delayInMillis);
		StubResponse stubResponse3 = new StubResponse(UriMatchers.simpleMatcher("www.test3.com"), "", delayInMillis);

		ProxyConfig proxyConfig=new ProxyConfig();
		proxyConfig.add(stubResponse1);
		proxyConfig.add(stubResponse2);
		proxyConfig.add(stubResponse3);


		middlemanApi.setProxyConfig(proxyConfig);
		middlemanApi.setConfiguration(middlemanconfiguration);
		when(middlemanconfiguration.hasProxy("proxyName")).thenReturn(true);
		when(middlemanconfiguration.getProxyByName("proxyName")).thenReturn(proxyConfig);

		middlemanApi.createStub("proxyName", "domain.co.uk", "200", new byte[0], new byte[0], 1000);
		assertThat(proxyConfig.getStubs().size(), is(4));
	}


}
