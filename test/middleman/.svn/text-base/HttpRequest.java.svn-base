package middleman;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

class HttpRequest {
    private final String target;
    private Proxy proxy;

    HttpRequest(String target, Proxy proxy) {
        this.target = target;
        this.proxy = proxy;
    }

    public HttpRequest(String target, String proxyHost, int proxyPort) {
        this(target, new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort)));
    }

    public HttpRequest(String target) {
        this(target, Proxy.NO_PROXY);
    }

    public HttpResponse makeRequest() {
        try {
            URL url = new URL(target);
            URLConnection urlConnection = url.openConnection(proxy);
            return new HttpResponse(urlConnection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
