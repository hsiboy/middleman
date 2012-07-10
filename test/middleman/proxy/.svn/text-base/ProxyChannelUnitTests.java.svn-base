package middleman.proxy;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import middleman.configuration.ProxyConfig;
import middleman.logging.ConsoleApplicationLog;
import middleman.logging.RequestLogger;
import middleman.utils.EventTimer;

import org.junit.Test;

public class ProxyChannelUnitTests {

	private static final String TEST_HOSTNAME = "www.test.com";
	private static final long DELAY_IN_MILLIS = 1000L;

	@Test
	public void canInstantiateProxyChannel() {
		new ProxyChannel(null, null, null, null, null);
	}

	@Test
	public void logResponseRecordsElapsedTime() throws Exception {
		RequestLogger logger = new RequestLogger();
		Socket socket = mock(Socket.class);
		when(socket.getInetAddress()).thenReturn(InetAddress.getLocalHost());

		ProxyChannel proxyChannel = new ProxyChannel(socket, null, logger, null, null);
		ProxyChannel.HTTPResponseInfo httpResponseInfo =  new ProxyChannel.HTTPResponseInfo(1234, "text/plain");
		proxyChannel.logRequestResponse(new EventTimer(), httpResponseInfo, new HTTPRequest());

		assertThat(logger.getEntries().size() == 1, is(true));
		assertThat(logger.getEntries().get(0).getBytesSent(), is(0));
		assertThat(logger.getEntries().get(0).getBytesReceived(), is(1234));
		assertThat(logger.getEntries().get(0).getResponseContentType(), is("text/plain"));
	}

	@Test
	public void shouldParseResponseContentTypeAndContentLength() throws ExternalResourceException {
		ProxyConfig config = mock(ProxyConfig.class);
		ProxyChannel proxyChannel = new ProxyChannel(null, config, null, new ConsoleApplicationLog(), null);
		String httpResponseData = "HTTP/1.x 200 OK\n" +
		"Via: 1.1 GTC-ISA01C\n" +
		"Connection: Keep-Alive\n" +
		"Proxy-Connection: Keep-Alive\n" +
		"Content-Length: 57\n" +
		"Date: Fri, 08 Jan 2010 16:58:41 GMT\n" +
		"Content-Type: image/gif\n" +
		"Etag: \"39-47670f42\"\n" +
		"Server: Sun-Java-System-Web-Server/7.0\n" +
		"Last-Modified: Tue, 18 Dec 2007 00:07:30 GMT\n" +
		"Accept-Ranges: bytes";
		ByteArrayInputStream input = new ByteArrayInputStream(httpResponseData.getBytes());
		ResponseHeader responseHeader = proxyChannel.readResponseHeader(input);
		assertThat(responseHeader.getContentType(), is("image/gif"));
		assertThat(responseHeader.getContentLength(), is(57));
	}

	@Test
	public void shouldParseResponseContentTypeWhenCharsetIsSet() throws ExternalResourceException {
		ProxyConfig config = mock(ProxyConfig.class);
		ProxyChannel proxyChannel = new ProxyChannel(null, config, null, new ConsoleApplicationLog(), null);
		String httpResponseData = createHttpResponseData("text/plain", "19587");
		ByteArrayInputStream input = new ByteArrayInputStream(httpResponseData.getBytes());

		ResponseHeader responseHeader = proxyChannel.readResponseHeader(input);

		assertThat(responseHeader.getContentType(), is("text/plain"));
	}

	@Test
	public void shouldDelayResponseForStubWhenADelayIsConfigured() throws ExternalResourceException, IOException {
		ProxyConfig config = mock(ProxyConfig.class);
		when(config.getDelayForHost(TEST_HOSTNAME)).thenReturn(DELAY_IN_MILLIS);

		ProxyChannel proxyChannel = new ProxyChannel(null, config, null, new ConsoleApplicationLog(), null);

		long currentTimeBefore=System.currentTimeMillis();
		proxyChannel.delayStubbedResponse(TEST_HOSTNAME);
		long currentTimeAfter=System.currentTimeMillis();

		long totalExecutionTimeMillis = currentTimeAfter-currentTimeBefore;
		verify(config).getDelayForHost(TEST_HOSTNAME);
		assertThat(totalExecutionTimeMillis, is(greaterThanOrEqualTo(DELAY_IN_MILLIS)));
	}

	private String createHttpResponseData(String mimeType, String contentLength) {
		return  "HTTP/1.x 200 OK\n" +
		"Content-Length: " + contentLength + "\n" +
		"Content-Type: " + mimeType + "; charset=utf-8\n" +
		"Content-Language: en-GB";
	}
}
