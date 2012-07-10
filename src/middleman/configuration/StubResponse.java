package middleman.configuration;

import static middleman.server.UriMatchers.patternMatcher;
import middleman.framework.UriMatcher;

public class StubResponse {
	private UriMatcher path;

	private String statusCode = "";
	private String body = "";
	private long delayInMillis;

	public StubResponse(){
	}

	public StubResponse(UriMatcher path, String body) {
		this(path, body, 0);
	}

	public StubResponse(UriMatcher path, String body, long delayInMillis){
		this.path = path;
		this.body = body;
		this.statusCode = "200";
		this.delayInMillis=delayInMillis;
	}


	public UriMatcher getPath() {
		return path;
	}

	public void setUrl(String text) {
		path = patternMatcher(text);
	}

	public void setHeader(String header) {
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public void setBody(String body) {
		this.body = body.substring(1, body.length()-1);
	}

	public String getBody() {
		return body;
	}

	public long getDelayInMillis() {
		return delayInMillis;
	}
}
