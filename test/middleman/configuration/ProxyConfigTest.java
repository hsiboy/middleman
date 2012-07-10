package middleman.configuration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import middleman.framework.UriMatcher;
import middleman.server.UriMatchers;

import org.junit.Test;

public class ProxyConfigTest {

	@Test
	public void shouldRecogniseLoopbackAddressAsLocalhost() {
		assertThat(new ProxyConfig().isLocalhost("127.0.0.1"), is(true));
	}

	@Test
	public void shouldMatchTheNegativePatternsWithPath() {
		ProxyConfig config = new ProxyConfig();
		config.add(new StubResponse(UriMatchers
				.patternMatcher("^((?!localhost)(?!172\\.27\\.137\\.217).)*$"),
		""));
		assertThat(config.stubbedRequest("localhost"), is(false));
		assertThat(config.stubbedRequest("172.27.137.217"), is(false));
		assertThat(config.stubbedRequest("some.otherhost.com"), is(true));
	}

	@Test
	public void shouldReturnADelayWhenStubConfiguredWithADelay() {
		ProxyConfig config = new ProxyConfig();
		long delayInMillis = 1001;
		config.add(new StubResponse(UriMatchers.simpleMatcher("www.test.com"),
				"", delayInMillis));
		assertThat(config.getDelayForHost("www.test.com"), is(delayInMillis));
	}

	@Test
	public void shouldAddStubToTopOfList() {
		ProxyConfig config = new ProxyConfig();
		long delayInMillis=1001;
		StubResponse stubResponse1 = new StubResponse(UriMatchers.simpleMatcher("www.test1.com"), "", delayInMillis);
		StubResponse stubResponse2 = new StubResponse(UriMatchers.simpleMatcher("www.test2.com"), "", delayInMillis);
		StubResponse stubResponse3 = new StubResponse(UriMatchers.simpleMatcher("www.test3.com"), "", delayInMillis);

		StubResponse testStub = new StubResponse(UriMatchers.simpleMatcher("www.testStub.com"), "", delayInMillis);

		config.add(stubResponse1);
		config.add(stubResponse2);
		config.add(stubResponse3);
		config.addToStubsAsFirst(testStub);
		UriMatcher retreivedFirstStubKey = config.getStubs().keySet().iterator().next();

		assertThat(config.getStubs().get(retreivedFirstStubKey), is(testStub));
		assertThat(config.getStubs().get(retreivedFirstStubKey), is(not(stubResponse1)));
	}
}
