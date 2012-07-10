package middleman.server.components;

import middleman.configuration.StubResponse;
import static middleman.server.UriMatchers.simpleMatcher;
import middleman.framework.RequestDocument;
import middleman.framework.UriMatcher;

import java.util.Map;

public class StubRequest implements RequestDocument {
    String path;
    String response;

    public void set(String header, String values) {
        if (header.equalsIgnoreCase("path")) {
            path = values;
        }

        if (header.equalsIgnoreCase("response")) {
            response = values;
        }
    }

    public void define(Map<UriMatcher, StubResponse> stubs) {
        UriMatcher key = simpleMatcher(path);
        stubs.put(key, new StubResponse(key, response));
    }

    public String getPath() {
        return path;
    }
}
