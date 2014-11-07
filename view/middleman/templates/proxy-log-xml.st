<?xml version="1.0" encoding="UTF-8"?>
<logs>
    <server>$proxy.name$</server>
    <requestsRunning>$requestCounter.numberOfRunningRequests$</requestsRunning>
    <millisecondsWithoutRunningRequest>$requestCounter.millisecondsWithoutRunningRequest$</millisecondsWithoutRunningRequest>
    $logs: {
        <request>
            <creationTime>$it.formattedCreationTime$</creationTime>
            <bytesSent>$it.bytesSent$</bytesSent>
            <bytesReceived>$it.bytesReceived$</bytesReceived>
            <elapsedTime>$it.elapsedTime$</elapsedTime>
            <successful>$it.requestSuccesfullCode$</successful>
            <contentType>$it.responseContentType$</contentType>
            <host>$it.host$</host>
            <path>$it.path$</path>
            <method>$it.method$</method>
            <operation>$it.operation$</operation>
        </request>
    }$
</logs>
