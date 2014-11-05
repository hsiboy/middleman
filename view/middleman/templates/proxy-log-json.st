{
	"logs" : {
		"server" : "$proxy.name$",
		"requestsRunning" : "$requestCounter.numberOfRunningRequests$",
    	"millisecondsWithoutRunningRequest" : "$requestCounter.millisecondsWithoutRunningRequest$",
	    "requests" : [$logs: {
	        {
	            "creationTime" : "$it.formattedCreationTime$",
	            "bytesSent" : "$it.bytesSent$",
	            "bytesReceived" : "$it.bytesReceived$",
	            "elapsedTime" : "$it.elapsedTime$",
	            "successfull" : "$it.requestSuccesfullCode$",
	            "contentType" : "$it.responseContentType$",
	            "host" : "$it.host$",
	            "path" : "$it.path$",
	            "method" : "$it.method$",
	            "operation" : "$it.operation$"
	        }
	    }$]
	}
}