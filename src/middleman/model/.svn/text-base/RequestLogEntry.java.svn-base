package middleman.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RequestLogEntry implements Comparable {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SSS");

    private long creationTime;
    private String method;
    private String host;
    private String path;
    private String responseContentType;
    private int bytesSent;
    private int bytesReceived;
    private long elapsedTime;
    private String operation;
    private boolean requestSuccesfull;

    public RequestLogEntry(long creationTime, String method, String host, String path, String responseContentType, int bytesSent, int bytesReceived, long elapsedTime, String operation, boolean requestSuccesfull) {
        this.creationTime = creationTime;
        this.method = method;
        this.host = host;
        this.path = path;
        this.responseContentType = responseContentType;
        this.bytesSent = bytesSent;
        this.bytesReceived = bytesReceived;
        this.elapsedTime = elapsedTime;
        this.operation = operation;
        this.requestSuccesfull = requestSuccesfull;
    }

    public String getMethod() {
        return method;
    }

    public String getHost() {
        return host;
    }

    public String getFormattedCreationTime() {
        return dateFormat.format(new Date(creationTime));
    }

    public String getPath() {
        return path;
    }

    public int getBytesSent() {
        return bytesSent;
    }

    public String getResponseContentType() {
        return responseContentType;
    }

    public int getBytesReceived() {
        return bytesReceived;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public String getOperation() {
        return operation;
    }

    public String getRequestSuccesfullCode(){
        return (requestSuccesfull)?("OK"):("ERROR");
    }

    public int compareTo(Object o) {
        RequestLogEntry other = (RequestLogEntry) o;
        return (int) (this.creationTime - other.creationTime);
    }
}
