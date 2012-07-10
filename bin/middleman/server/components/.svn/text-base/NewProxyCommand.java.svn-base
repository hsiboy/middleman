package middleman.server.components;

import middleman.framework.Command;
import middleman.server.WebContext;

public class NewProxyCommand implements Command {
    public void executeCommand(WebContext context) {
        NewProxyRequestDocument document = new NewProxyRequestDocument();
        context.fillRequestDocument(document);

        context.startNewProxy(document);
        context.redirectTo("/" + document.proxyName);

    }
}
