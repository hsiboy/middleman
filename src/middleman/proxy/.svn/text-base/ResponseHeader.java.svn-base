package middleman.proxy;

class ResponseHeader {
    private String headerData;
    private int responseCode;
    private int contentLength;
    private String contentType;

    public void updateContentLength(String data) {
        int pos = data.toLowerCase().indexOf("content-length:");
        if (pos >= 0) {
            contentLength = Math.max(contentLength, Integer.parseInt(data.substring(pos + 15).trim()));
        }
    }

    public void updateContentType(String data) {
        int pos = data.toLowerCase().indexOf("content-type:");
        if (pos >= 0) {
            contentType = data.substring(pos + 13).split(";")[0].trim();
        }
    }

    public void setHeaderData(String headerData) {
        this.headerData = headerData;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getContentType() {
        return contentType;
    }

    public int getContentLength() {
        return contentLength;
    }

    public String getHeaderData() {
        return headerData;
    }
}
