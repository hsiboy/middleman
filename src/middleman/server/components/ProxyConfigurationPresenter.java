package middleman.server.components;

import static middleman.server.WebContext.attribute;
import static middleman.server.WebContext.with;
import middleman.framework.Presenter;
import middleman.server.WebContext;

public class ProxyConfigurationPresenter implements Presenter {

    public void present(WebContext context) {
        context.renderTemplateHtmlResponse("proxy",
            with(
                attribute("proxy", context.getServerConfig()),
                attribute("stubs", context.getServerConfig().getStubs())
            )
        );
    }
}
