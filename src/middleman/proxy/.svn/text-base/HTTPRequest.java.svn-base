package middleman.proxy;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPRequest {
    private byte[] requestData;
    private String hostName = "";
    private int port = 80;
    private int contentLength = 0;
    private String path;
    private volatile byte[] headerData;
    private int originalHeaderSize;
    private String method = "";

    public HTTPRequest() {
        path = "";
    }

    public String getHostName() {
        return hostName;
    }

    public String getPath() {
        return path;
    }

    public int getPort() {
        return port;
    }

    public int length() {
        return requestData == null ? 0 : Array.getLength(requestData);
    }

    public void write(BufferedOutputStream outputStream) throws IOException {
        outputStream.write(headerData, 0, headerData.length);
        outputStream.write(requestData, originalHeaderSize, length() - originalHeaderSize);
    }

    public void readRequestLine(String data) {
        String[] fields = data.split(" ");
        method = fields[0];
        String requestUri = fields[1];
        try {
            URL url = new URL(requestUri);
            
            hostName = url.getHost();
            if (url.getPort() != -1) {
                port = url.getPort();
            }
            path = requestUri.split("://[^/]+")[1];

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addConnectionCloseHeader() {
        String modifiedHeader = new String(headerData) + "Connection: close\r\n";
        headerData = modifiedHeader.getBytes();
    }

    public void setHeaderData(byte[] headerData) {
        this.headerData = headerData;
        originalHeaderSize = headerData.length;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setRequestData(byte[] requestData) {
        this.requestData = requestData;
    }

    public String getMethod() {
        return method;
    }

    public void addHeader(String name, String value) {
        String originalHeader = new String(headerData);
        String updatedHeader = originalHeader + name + ": " + value + "\r\n";
        headerData = updatedHeader.getBytes();
    }
    
    @Override
    public String toString() {
    	return String.format("to: %s\nheaders:%s", hostName, new String(headerData));
    }
}
