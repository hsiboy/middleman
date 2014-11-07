			$middleman/templates/header(title="Home | Middleman - Dynamic Proxy Server")$
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
			$middleman/templates/footer()$