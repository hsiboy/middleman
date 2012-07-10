package middleman.server.components;

import middleman.framework.Presenter;
import middleman.logging.RequestLogger;
import middleman.server.WebContext;

import static middleman.server.components.ProxyLogPresenter.withLogAttributes;

public class ProxyLogXMLPresenter implements Presenter {

    private final RequestLogger logs;

    public ProxyLogXMLPresenter(RequestLogger logs) {
        this.logs = logs;
    }

    public void present(WebContext context) {
        context.renderTemplateXMLResponse("proxy-log-xml", withLogAttributes(context, logs));
    }
}
