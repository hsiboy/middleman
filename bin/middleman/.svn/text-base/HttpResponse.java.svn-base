package middleman;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

class HttpResponse {
    private final Map<String, List<String>> headerFields;
    private String content;

    public HttpResponse(URLConnection urlConnection) throws IOException {
        InputStream inputStream = urlConnection.getInputStream();
        content = IOUtils.toString(inputStream);
        inputStream.close();

        headerFields = urlConnection.getHeaderFields();
    }

    public boolean containsHeader(String header, String value) {
        if(!headerFields.containsKey(header)) {
            return false;
        }

        return headerFields.get(header).get(0).equals(value);
    }

    public Xml asXml() {
        return new Xml(IOUtils.toInputStream(content));
    }

    public String toString() {
        return content;
    }
}
