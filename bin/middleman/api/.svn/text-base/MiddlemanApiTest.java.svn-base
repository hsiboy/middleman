package middleman.api;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import middleman.proxy.ProxyServer;
import middleman.proxy.RequestFilter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


public class MiddlemanApiTest {

	@Mock ProxyServer proxy;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void shouldAddRequestFilterToProxy() {
		new MiddlemanController().control(proxy);

		verify(proxy).setProxyRequestFilter(Mockito.isA(RequestFilter.class));
	}

}
