		$middleman/templates/header(title={Requests Log - $proxy.name$ | Middleman})$
		    <div class="title">Proxy server "$proxy.name$" Logs</div>
		    <div class="back">Your are here: <a href="/">Home</a> &gt; <a href="/$proxy.name$">Proxy server "$proxy.name$"</a> &gt; Requests Log</div>
		    <form id="resetlogs" action="/$proxy.name$/log/reset" method="POST" name="resetlogs">
		        <button type="submit">Clear Log</button>
		        <a class="button" href="/$proxy.name$/log">Refresh Log</a>
		        <a class="download" href="/$proxy.name$/log/csv">Download this log as CSV</a> | 
		        <a class="download" href="/$proxy.name$/log/xml">View XML</a> | 
		        <a class="download" href="/$proxy.name$/log/json">View JSON</a> |
		        <a class="download" href="/$proxy.name$/log/jsonp">View JSONP</a>
		    </form>
		    <div>
		    	<span class="requestsRunning">$requestCounter.numberOfRunningRequests$</span> requests are still in process, no requests have been processed in the last <span id="millisecondsWithoutRunningRequest">$requestCounter.millisecondsWithoutRunningRequest$</span> milliseconds.
		    </div>
		    <table>
		        <thead>
		            <tr>
		                <th>Creation Time</th>
		                <th>Bytes Sent</th>
		                <th>Bytes Received</th>
		                <th>Elapsed Time (ms)</th>
		                <th>Request result</th>
		                <th>Request Content</th>
		                <th>Response content type</th>
		                <th>Host</th>
		                <th>Path</th>
		                <th>HTTP method</th>
		                <th>Operation</th>
		            </tr>
		        </thead>
		        $logs: {
		            <tr class="request">
		                <td class="creationTime">$it.formattedCreationTime$</td>
		                <td class="bytesSent">$it.bytesSent$</td>
		                <td class="bytesReceived">$it.bytesReceived$</td>
		                <td class="elapsedTime">$it.elapsedTime$</td>
		                <td class="successfull">$it.requestSuccesfullCode$</td>
		                <td class="requestContent">$it.htmlEncodedRequestData$</td>
		                <td class="contentType">$it.responseContentType$</td>
		                <td class="host">$it.host$</td>
		                <td class="path">$it.path$</td>
		                <td class="method">$it.method$</td>
		                <td class="operation">$it.operation$</td>
		            </tr>
		        }$
		    </table>
		$middleman/templates/footer()$