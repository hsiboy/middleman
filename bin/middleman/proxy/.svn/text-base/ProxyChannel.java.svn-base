package middleman.proxy;

import static middleman.utils.Utils.close;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import middleman.configuration.ProxyConfig;
import middleman.configuration.StubResponse;
import middleman.logging.ApplicationLog;
import middleman.logging.RequestLogger;
import middleman.model.RequestLogEntry;
import middleman.server.StreamControl;
import middleman.utils.EventTimer;
import middleman.utils.Utils;

public class ProxyChannel extends Thread {
	private Socket socket;
	private ProxyConfig config;
	private RequestLogger requestLogger;
	private ApplicationLog applicationLog;
	private long creationTime;
	private static final int CONNECTION_TIMEOUT = 5000;
	private final RequestFilter proxyRequestFilter;

	public ProxyChannel(Socket socket, ProxyConfig config, RequestLogger requestLogger, ApplicationLog applicationLog, RequestFilter proxyRequestFilter) {
		this.socket = socket;
		this.config = config;
		this.requestLogger = requestLogger;
		this.applicationLog = applicationLog;
		this.proxyRequestFilter = proxyRequestFilter;
		creationTime = System.currentTimeMillis();
	}

	@Override
	public void run() {
		RequestsCounter.getInstance().started();
		BufferedInputStream clientIn = null;
		BufferedOutputStream clientOutputStream = null;
		HTTPRequest request;
		try {
			try {
				clientIn = new BufferedInputStream(socket.getInputStream());
				request = getHTTPData(clientIn);
			} catch (IOException e) {
				applicationLog.log("Error reading input socket: ", e);
				return;
			}

			try {
				clientOutputStream = new BufferedOutputStream(socket.getOutputStream());

				if (config.stubbedRequest(request.getHostName())) {
					delayStubbedResponse(request.getHostName());
					handleStubbedResponse(clientOutputStream, request);
				} else {
					filterProxyRequest(request);
					handleProxyRequest(clientOutputStream, request);
				}
			} catch (IOException e) {
				applicationLog.log("Error sending data to client ", e);
			}

		} finally {
			RequestsCounter.getInstance().finished();
			close(clientIn);
			close(clientOutputStream);
			close(socket);
		}
	}

	void delayStubbedResponse(String hostName) {
		long delayForHost = config.getDelayForHost(hostName);

		try {
			Thread.sleep(delayForHost);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	private void filterProxyRequest(HTTPRequest request) {
		if (proxyRequestFilter != null) {
			proxyRequestFilter.filterRequest(request);
		}
	}

	private void handleProxyRequest(BufferedOutputStream clientOutputStream, final HTTPRequest request) throws IOException {
		final EventTimer timer = new EventTimer();
		InputStream outboundInputStream = null;
		BufferedOutputStream outboundOutputStream = null;
		try {
			try {
				//open connection to the resource server
				Socket outboundSocket = openOutboundSocket(request);
				outboundInputStream = new BufferedInputStream(outboundSocket.getInputStream());
				outboundOutputStream = new BufferedOutputStream(outboundSocket.getOutputStream());

				// send the requestFromMiddleman to the resource server
				request.addConnectionCloseHeader();
				
				request.write(outboundOutputStream);
				outboundOutputStream.flush();
			} catch (IOException e){
				throw new ExternalResourceException(e);
			}

			streamHTTPResponse(outboundInputStream, clientOutputStream, new ResponseServed() {
				public void info(HTTPResponseInfo responseInfo) {
					logRequestResponse(timer, responseInfo, request);
				}
			});
		} catch(ExternalResourceException e){
			logFailedRequestResponse(timer, request);
			sendClientErrorMessage(clientOutputStream, request, (IOException) e.getCause());
		} finally {
			close(outboundInputStream);
			close(outboundOutputStream);
		}
	}

	private Socket openOutboundSocket(HTTPRequest request) throws IOException {
		String hostname = request.getHostName();
		int port = request.getPort();
		if (config.hasOutgoingProxyFor(request.getHostName())) {
			hostname = config.getOutgoingProxyHost();
			port = config.getOutgoingProxyPort();
		}
		Socket socket = new Socket();

		socket.bind(null);
		InetSocketAddress socketAddress = new InetSocketAddress(hostname, port);
		socket.connect(socketAddress, CONNECTION_TIMEOUT);
		return socket;

	}

	private void sendClientErrorMessage(BufferedOutputStream clientOutputStream, HTTPRequest request, IOException e) {
		// tell the client there was an error

		String errBody = "Error connecting to the remoteServerSocket:\n"
			+ " host " + request.getHostName() + "\n"
			+ " port " + request.getPort() + "\n"
			+ " path " + request.getPath() + "\n"
			+ "Error " + e;

		String errResponse = "HTTP/1.0 500\nContent-Type: text/plain\nContent-Length:" + errBody.length() + "\n\n" + errBody;

		applicationLog.log(errBody);
		try {
			clientOutputStream.write(errResponse.getBytes(), 0, errResponse.length());
		} catch (IOException e1) {
			throw new RuntimeException(e1);
		}
	}

	protected void logRequestResponse(EventTimer timer, HTTPResponseInfo responseInfo, HTTPRequest request) {
		requestLogger.log(new RequestLogEntry(creationTime,
				request.getMethod(),
				request.getHostName() + ":" + request.getPort(),
				request.getPath(),
				responseInfo.getContentType(),
				request.length(),
				responseInfo.getBytesReceived(),
				timer.elapsed(), "PROXY", true));
	}

	protected void logFailedRequestResponse(EventTimer timer, HTTPRequest request) {
		requestLogger.log(new RequestLogEntry(creationTime,
				request.getMethod(),
				request.getHostName() + ":" + request.getPort(),
				request.getPath(),
				"",
				request.length(),
				0,
				timer.elapsed(), "PROXY", false));
	}

	private void handleStubbedResponse(BufferedOutputStream clientOut, HTTPRequest request) throws IOException {
		requestLogger.log(new RequestLogEntry(creationTime,
				request.getMethod(),
				request.getHostName() + ":" + request.getPort(),
				request.getPath(),
				"text/plain",
				request.length(),
				0,
				0, "STUB", true));
		StubResponse stubResponse = config.getStubbedResponse(request.getHostName());
		String message = String.format("HTTP/1.0 %s\nContent-Type: text/plain\nContent-Encoding: UTF-8\nContent-Length: %d\n\n%s", stubResponse.getStatusCode(), stubResponse.getBody().length(), stubResponse.getBody());
		clientOut.write(message.getBytes(), 0, message.length());
		clientOut.flush();

	}

	private HTTPRequest getHTTPData(InputStream in) throws IOException {
		HTTPRequest request = new HTTPRequest();
		// get the HTTP data from an InputStream, and return it as
		// a byte array, and also return the Host entry in the header,
		// if it's specified -- note that we have to use a StringBuffer
		// for the 'host' variable, because a String won't return any
		// information when it's used as a parameter like that
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		// get the HTTP data from an InputStream, and send it to
		// the designated OutputStream
		StringBuilder header = new StringBuilder("");

		readRequestHeader(in, request, header);
		request.setHeaderData(header.toString().getBytes());

		// add a blank line to terminate the header info
		header.append("\r\n");

		// convert the header to a byte array, and write it to our stream
		bs.write(header.toString().getBytes(), 0, header.length());

		try {
			copyResponse(in, bs, new StreamControl(request.getContentLength(), false));
		} catch (InputReadException e){
			throw (IOException)e.getCause();
		}

		request.setRequestData(bs.toByteArray());
		return request;
	}

	private interface ResponseServed {
		void info(HTTPResponseInfo info);
	}

	private void streamHTTPResponse(InputStream in, OutputStream out, ResponseServed responseServed) throws ExternalResourceException {
		boolean waitForDisconnect = true;
		// get the HTTP data from an InputStream, and send it to
		// the designated OutputStream
		ResponseHeader responseHeader;
		int transferredBytes = 0;
		String contentType = "";
		StringBuilder headerBody = new StringBuilder();
		try {
			responseHeader = readResponseHeader(in);
			contentType = responseHeader.getContentType();
			headerBody.append(responseHeader.getHeaderData());

			// add a blank line to terminate the header info
			headerBody.append("\r\n");

			int length = headerBody.length();
			byte[] bytes = headerBody.toString().getBytes();

			// convert the header to a byte array, and write it to our stream
			out.write(bytes, 0, length);

			// if the header indicated that this was not a 200 response,
			// just return what we've got if there is no Content-Length,
			// because we may not be getting anything else
			int responseCode = responseHeader.getResponseCode();
			if ((responseCode < 200 && responseCode > 299) && (responseHeader.getContentLength() == 0)) {
				responseServed.info(new HTTPResponseInfo(length));
				out.flush();
				return;
			}

			if (responseHeader.getContentLength() > 0) {
				waitForDisconnect = false;
			}

			transferredBytes = copyResponse(in, out, new StreamControl(responseHeader.getContentLength(), waitForDisconnect));
		} catch (IOException e) {
			applicationLog.log("Error getting HTTP data: ", e);
		} catch (InputReadException e){
			throw new ExternalResourceException((IOException) e.getCause());
		}

		//flush the OutputStream and return
		try {
			responseServed.info(new HTTPResponseInfo(headerBody.length() + transferredBytes, contentType));
			out.flush();
		} catch (Exception e) {
			applicationLog.log("Error flushing output stream ", e);
		}
	}

	private void readRequestHeader(InputStream in, HTTPRequest httpRequest, StringBuilder header) throws IOException {
		String data;

		data = Utils.readLine(in);
		if (data != null) {
			httpRequest.readRequestLine(data);
			header.append(data).append("\r\n");
		}

		while ((data = Utils.readLine(in)) != null) {
			if (data.length() == 0)
				break;

			header.append(data).append("\r\n");

			int pos = data.toLowerCase().indexOf("content-length:");
			if (pos >= 0) {
				httpRequest.setContentLength(Integer.parseInt(data.substring(pos + 15).trim()));
			}
		}
	}

	ResponseHeader readResponseHeader(InputStream in) throws ExternalResourceException {
		StringBuilder headerBuffer = new StringBuilder();

		ResponseHeader responseHeader = new ResponseHeader();

		try {
			String data = Utils.readLine(in);
			if (data != null) {
				headerBuffer.append(data).append("\r\n");
				responseHeader.setResponseCode(parseResponseCode(data));
			}

			while ((data = Utils.readLine(in)) != null) {
				if (data.length() == 0)
					break;
				headerBuffer.append(data).append("\r\n");
				responseHeader.updateContentLength(data);
				responseHeader.updateContentType(data);
			}

			responseHeader.setHeaderData(headerBuffer.toString());
		} catch (IOException e) {
			applicationLog.log("Error getting header: ", e);
			throw new ExternalResourceException(e);
		}

		return responseHeader;
	}

	private int copyResponse(InputStream inputStream, OutputStream outputStream, StreamControl streamControl) throws InputReadException {
		int totalBytesReceived = 0;
		if (streamControl.dataExpected()) {
			trace("copyResponse", streamControl.toString());
			try {
				byte[] buf = new byte[40960];
				int bufferedByteCount = 0;
				while (streamControl.moreDataExpected(totalBytesReceived) && !eof(bufferedByteCount)) {
					try {
						bufferedByteCount = inputStream.read(buf);
					} catch(IOException exc){
						throw new InputReadException(exc);
					}
					if (!eof(bufferedByteCount)) {
						outputStream.write(buf, 0, bufferedByteCount);
						totalBytesReceived += bufferedByteCount;
					}
					trace("copyResponse", "read " + totalBytesReceived + " of " + streamControl.expected());
				}
			} catch (IOException e) {
				applicationLog.log("Error getting HTTP body: ", e);
			}
		}
		trace("copyResponse", "complete");
		return totalBytesReceived;
	}

	private boolean eof(int bytesIn) {
		return bytesIn < 0;
	}

	private int parseResponseCode(String data) {
		int pos;
		pos = data.indexOf(" ");
		if ((data.toLowerCase().startsWith("http")) && (pos >= 0) && (data.indexOf(" ", pos + 1) >= 0)) {

			String rcString = data.substring(pos + 1, data.indexOf(" ", pos + 1));
			try {
				trace("parseResponseCode", "Response code " + rcString);
				return Integer.parseInt(rcString);
			} catch (NumberFormatException e) {
				applicationLog.log("Error parsing response code " + rcString);
			}
		}
		return 200;
	}

	private void trace(String method, String message) {
		if (config.getDebugLevel() > 1) {
			applicationLog.trace(Thread.currentThread().getId() + " " + method + ": " + message);
		}
	}

	static class HTTPResponseInfo {
		private int bytesReceived;
		private String contentType;

		HTTPResponseInfo(int bytesReceived) {
			this.bytesReceived = bytesReceived;
		}

		HTTPResponseInfo(int bytesReceived, String contentType) {
			this.bytesReceived = bytesReceived;
			this.contentType = contentType;
		}

		public String getContentType() {
			return contentType;
		}

		public int getBytesReceived() {
			return bytesReceived;
		}
	}

	private class InputReadException extends Throwable {
		public InputReadException(IOException exc) {
			super(exc);
		}
	}
}
