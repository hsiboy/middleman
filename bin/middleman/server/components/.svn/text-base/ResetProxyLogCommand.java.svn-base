package middleman.server.components;

import middleman.logging.RequestLogger;
import middleman.framework.Command;
import middleman.server.WebContext;

public class ResetProxyLogCommand implements Command {
    private RequestLogger logger;

    public ResetProxyLogCommand(RequestLogger logger) {
        this.logger = logger;
    }
    public void executeCommand(WebContext context) {
        logger.clear();
        context.redirectTo("/" + context.getServerConfig().getName() + "/log");
    }
}
