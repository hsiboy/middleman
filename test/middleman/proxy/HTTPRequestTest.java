package middleman.proxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;

public class HTTPRequestTest {

    String httpProtocol = "http://";

    String domain = "metrics.autotrader.co.uk";
    int port = 8080;

    String file = "/b/ss/tmlautotrader1/1/H.20.3/s96181943749954?AQB=1&ndh=1&t=8/0/2010%2010%3A37%3A32%205%200&ns=tradermediagroup&cdp=3&pageName=cars%3Ahome&g=http%3A//www.autotrader.co.uk/&ch=cars&events=event2&c1=cars%3Ahome&v1=cars%3Ahome&h1=cars%2Chome&c5=cars&v5=cars&c9=10%3A30AM&v9=10%3A30AM&c10=Friday&v10=Friday&c11=Weekday&v11=Weekday&c26=Repeat&v26=Repeat&c29=no&v29=no&c31=at2%3Acars%3Ahome&v31=at2%3Acars%3Ahome&v35=cars%3Ahome&v36=cars&s=1680x1050&c=32&j=1.7&v=Y&k=Y&p=Mozilla%20Default%20Plug-in%3BAdobe%20Acrobat%3BJava%28TM%29%20Platform%20SE%206%20U11%3BGoogle%20Update%3BShockwave%20Flash%3BShockwave%20for%20Director%3BMicrosoft%AE%20DRM%3BWindows%20Media%20Player%20Plug-in%20Dynamic%20Link%20Library%3B&AQE=1#something";

    String httpUrlString = httpProtocol + domain + file;
    String httpUrlWithPortString = httpProtocol + domain + ":" + port + file;

    String httpRequestLine = "GET " + httpUrlString + " HTTP/1.1";
    String httpRequestLineWithPort = "GET " + httpUrlWithPortString + " HTTP/1.1";

    @Test
    public void shouldParseHttpURL(){
        HTTPRequest httpRequest = new HTTPRequest();
        httpRequest.readRequestLine(httpRequestLine);
        assertThat(httpRequest.getPath(),is(file));
        assertThat(httpRequest.getHostName(),is(domain));
        assertThat(httpRequest.getPort(),is(80));
    }

    @Test
    public void shouldParseHttpURLwithPort(){
        HTTPRequest httpRequest = new HTTPRequest();
        httpRequest.readRequestLine(httpRequestLineWithPort);
        assertThat(httpRequest.getPath(),is(file));
        assertThat(httpRequest.getHostName(),is(domain));
        assertThat(httpRequest.getPort(),is(port));
    }

    @Test
    public void shouldAddHeaderToEndOfExistingHeaders() throws Exception {
        HTTPRequest httpRequest = new HTTPRequest();
        String httpRequestLine = "GET http://metrics.autotrader.co.uk/somefile HTTP/1.1\r\n";
        String originalHeader = "Host: www.example.com\r\n" + 
                                "Content-Length: " + "body".getBytes().length + "\r\n";
        httpRequest.readRequestLine(httpRequestLine);
        httpRequest.setHeaderData(originalHeader.getBytes());
        httpRequest.setRequestData((originalHeader + 
                                   "\r\n" + 
                                   "body").getBytes());
        
        httpRequest.addHeader("HeaderX", "abc");
        
        String requestContent = getRequestContentWithoutHttpRequestLine(httpRequest);
        assertThat(requestContent, is(originalHeader + 
                                      "HeaderX: abc\r\n" +
                                      "\r\n" +
                                      "body"));
    }

    private String getRequestContentWithoutHttpRequestLine(HTTPRequest httpRequest) throws IOException {
        ByteArrayOutputStream outputBytesStream = new ByteArrayOutputStream();
        BufferedOutputStream outputStream = new BufferedOutputStream(outputBytesStream);
        httpRequest.write(outputStream);
        outputStream.flush();
        return outputBytesStream.toString();
    }
}
