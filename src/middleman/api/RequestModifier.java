package middleman.api;

import middleman.proxy.HTTPRequest;


public class RequestModifier {

    private volatile String name;
    private volatile String value;

    public RequestModifier addingHeader(String name, String value) {
        this.name = name;
        this.value = value;
        return this;
    }

    public void modifyRequest(HTTPRequest request) {
        request.addHeader(name, value);
    }
}
