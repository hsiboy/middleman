package middleman.framework;

import java.net.URI;

public interface UriMatcher {
    boolean matches(URI requestUri);
}
