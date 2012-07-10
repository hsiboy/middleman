package middleman.server.components;

import middleman.framework.Presenter;
import middleman.logging.RequestLogger;
import middleman.proxy.RequestsCounter;
import middleman.server.WebContext;

import static middleman.server.WebContext.attribute;
import static middleman.server.WebContext.with;

public class ProxyLogPresenter implements Presenter {
    private RequestLogger logs;

    public ProxyLogPresenter(RequestLogger logs) {
        this.logs = logs;
    }

    public void present(WebContext context) {
        context.renderTemplateHtmlResponse("proxy-log", withLogAttributes(context, logs));
    }

    public static TemplateAttributes withLogAttributes(WebContext context, final RequestLogger logs) {
        return with(
                attribute("requestCounter", RequestsCounter.getInstance()),
                attribute("proxy", context.getServerConfig()),
                attribute("logs", logs.getEntries())
        );
    }
}
