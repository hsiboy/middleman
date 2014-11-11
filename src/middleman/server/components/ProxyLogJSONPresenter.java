package middleman.server.components;

import middleman.framework.Presenter;
import middleman.logging.RequestLogger;
import middleman.server.WebContext;

import static middleman.server.components.ProxyLogPresenter.withLogAttributes;

public class ProxyLogJSONPresenter implements Presenter {

    private final RequestLogger logs;
    private final Boolean jsonp;

    public ProxyLogJSONPresenter(RequestLogger logs, Boolean jsonp) {
        this.logs = logs;
        this.jsonp = jsonp;
    }

    public void present(WebContext context) {
        context.renderTemplateJSONResponse("proxy-log-json", withLogAttributes(context, logs, jsonp), jsonp);
    }
}
