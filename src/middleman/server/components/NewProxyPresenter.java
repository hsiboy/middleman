package middleman.server.components;

import middleman.framework.Presenter;
import middleman.server.WebContext;

public class NewProxyPresenter implements Presenter {
    public void present(WebContext context) {
        context.renderTemplateResponse("new-proxy");
    }
}
