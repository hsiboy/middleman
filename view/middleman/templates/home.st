<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  		<title dir="ltr">Home | Middleman - Dynamic Proxy Server</title>
  		<meta name="viewport" content="width=device-width">
	    <link href="middleman.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div class="content">
			<div class="box">
			    <div class="title">Middleman dynamic proxy configuration</div>
			    <div class="back">Your are here: Home</div>
			    <div class="status">&curren; Middleman is currently running on port $port$</div>
			</div>
			<p>Welcome to Middleman, a dynamic proxy server. <a href="/doc/index.html">Please read the documentation</a></p>
			<div class="box">
			    <div class="subtitle">Currently configured proxy servers</div>
			    <ul>
			        $proxies: {
			        <li><a href="/$it.name$">$it.name$</a></li>
			        }$
			    </ul>
			</div>
			<div class="box">
			    <a id="newProxyBtn" class="button" href="/proxy/new">Create New Proxy</a>
			    <form class="stop" action="/stop" method="POST">
			        <button type="submit">Stop Middleman</button>
			    </form>
			</div>
			<div class="footer">
		    	&copy; Middleman 2010 - 2014 - <a href="/doc/index.html">Documentation</a> | <a href="http://github.com/hsiboy/middleman">hosted on Github</a>
		    </div>
		</div>
	</body>
</html>