<html>
<head>
    <title>Middleman - Server</title>
    <link href="middleman.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="content">
    <div class="title">Middleman dynamic proxy configuration</div>
    <a class="back" href="/doc/index.html">Middleman documentation</a>
    <div class="content">
        <div class="status">Middleman is currently running on port $port$</div>
    </div>

    <div class="subtitle">Currently configured proxy servers</div>
    <ul>
        $proxies: {
        <li><a href="/$it.name$">$it.name$</a></li>
        }$
    </ul>
    <a href="/proxy/new">New Proxy</a>

    <form action="/stop" method="POST">
        <button type="submit">Stop</button>
    </form>

</div>
</body>
</html>
