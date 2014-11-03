<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  		<title dir="ltr">Create New Proxy | Middleman</title>
  		<meta name="viewport" content="width=device-width">
	    <link rel="stylesheet" type="text/css" href="/middleman.css">
	</head>
	<body>
		<div class="content">
		    <div class="title">Create a new proxy server</div>
		    <div class="back">Your are here: <a href="/">Home</a> &gt; Create a new proxy server</div>
		    <form class="stubform" action="/proxy/new" method="POST" name="create-proxy">
		        <fieldset>
		            <label for="proxy-name">Proxy Name</label>
		            <input type="text" id="proxy-name" name="proxy-name"/>
		            <label for="proxy-port">Proxy Port</label>
		            <input type="text" id="proxy-port" name="proxy-port"/>
		        </fieldset>
		        <button type="submit">Create Proxy</button>
		        <a class="button" href="/">Cancel</a>
		    </form>
		    <div class="footer">
		    	&copy; Middleman 2010 - 2012 - <a href="/doc/index.html">Middleman documentation</a>
		    </div>
		</div>
	</body>
</html>
