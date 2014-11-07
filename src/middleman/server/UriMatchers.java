package middleman.server;

import middleman.framework.UriMatcher;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class UriMatchers {
    public static UriMatcher patternMatcher(String patternText) {
        final Pattern pattern = Pattern.compile(patternText);
        return new UriMatcher() {
            public boolean matches(URI requestUri) {
                return pattern.matcher(stripTrailingSlashIfNotRoot(requestUri)).matches();
            }

            public String toString() {
                return pattern.toString();
            }
        };
    }

    public static UriMatcher simpleMatcher(final String name) {
        return new UriMatcher() {
            public boolean matches(URI requestUri) {
                return name.compareToIgnoreCase(stripTrailingSlashIfNotRoot(requestUri)) == 0;
            }

            public String toString() {
                return name;
            }
        };
    }

    public static UriMatcher pathMatcher(final String... pathElements) {
        StringBuilder path = new StringBuilder();
        for (String pathElement : pathElements) {
            path.append("/")
                    .append(pathElement);
        }

        final String comparison = path.toString();
        return new UriMatcher() {

            public boolean matches(URI requestUri) {
                return comparison.compareToIgnoreCase(stripTrailingSlashIfNotRoot(requestUri)) == 0;
            }

            public String toString() {
                return comparison;
            }
        };
    }

    static UriMatcher classpathMatcher() {
        return new UriMatcher() {
            public boolean matches(URI requestUri) {
                InputStream stream = null;
                try {
                    stream = MiddlemanServer.class.getResourceAsStream(stripTrailingSlashIfNotRoot(requestUri));
                    return stream != null;
                } finally {
                    if (stream != null) {
                        try {
                            stream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
    }
    
    private static String stripTrailingSlashIfNotRoot(URI requestUri) {
    	String url = requestUri.toString();
    	int count = StringUtils.countMatches(url, "/");
    	
    	if (count > 1 && url.endsWith("/")) {
    		url = url.substring(0, url.length() - 1);
    	}
    	
    	return url;
    }
}
