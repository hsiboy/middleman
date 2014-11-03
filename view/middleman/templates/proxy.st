<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  		<title dir="ltr">Proxy Configuration - $proxy.name$ | Middleman</title>
  		<meta name="viewport" content="width=device-width">
	    <link rel="stylesheet" type="text/css" href="/middleman.css">
	</head>
	<body>
		<div class="content">
			<div class="box">
		    	<div class="title">Proxy server "$proxy.name$"</div>
		    	<div class="back">Your are here: <a href="/">Home</a> &gt; Proxy server "$proxy.name$"</div>
		    </div>
		    <div class="configuration">
		        <table>
		            <tr>
		                <td>Debug level</td>
		                <td>$proxy.debugLevel$</td>
		            </tr>
		            <tr>
		                <td>Listening on port</td>
		                <td>$proxy.port$</td>
		            </tr>
		            <tr>
		                <td>Outgoing proxy host</td>
		                <td>$proxy.OutgoingProxyHost$</td>
		            </tr>
		            <tr>
		                <td>Outgoing proxy host</td>
		                <td>$proxy.OutgoingProxyPort$</td>
		            </tr>
		        </table>
		    </div>
		    <div class="clear">&nbsp;</div>
		    <a href="/$proxy.name$/log">&gt;&gt; View proxy $proxy.name$ requests log</a>
		    <div class="subtitle">Stubs</div>
		    <form class="stubform" action="/$proxy.name$/stub/new" method="POST" name="new-stub">
		        <fieldset id="stub">
		            <label for="path">Path to stub</label>
		            <input type="text" id="path" name="path"/>
		            <label for="response">Enter the text to be returned to the client browser when the path is requested</label>
		            <input type="text" id="response" name="response"/>
		            <button type="submit">Create Stub</button>
		        </fieldset>
		    </form>
		    <div class="stublist">
		        <table>
		            <tr>
		                <th>Stubbed path</th>
		                <th>Status code</th>
		                <th>Response data</th>
		            </tr>
		            $stubs: {
		            <tr>
		                <td>$it.path$</td>
		                <td>$it.statusCode$</td>
		                <td>$it.body$</td>
		            </tr>
		            }$
		        </table>
		    </div>
			<div class="footer">
		    	&copy; Middleman 2010 - 2012 - <a href="/doc/index.html">Middleman documentation</a>
		    </div>
		</div>
	</body>
</html>