		$middleman/templates/header(title="Create New Proxy | Middleman")$
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
		$middleman/templates/footer()$