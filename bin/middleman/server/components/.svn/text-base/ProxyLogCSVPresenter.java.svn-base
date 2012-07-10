package middleman.server.components;

import middleman.framework.Presenter;
import middleman.logging.RequestLogger;
import middleman.server.WebContext;
import static middleman.server.WebContext.attribute;
import static middleman.server.WebContext.with;
import static middleman.server.components.ProxyLogPresenter.*;

public class ProxyLogCSVPresenter implements Presenter {
    private RequestLogger logs;

    public ProxyLogCSVPresenter(RequestLogger logs) {
        this.logs = logs;
    }

    public void present(WebContext context) {
       context.renderTemplateCSVResponse("proxy-log-csv", withLogAttributes(context, logs));
    }
}

