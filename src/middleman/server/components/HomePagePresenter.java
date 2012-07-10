package middleman.server.components;

import middleman.configuration.MiddlemanConfiguration;
import middleman.framework.Presenter;
import middleman.server.WebContext;
import static middleman.server.WebContext.attribute;
import static middleman.server.WebContext.with;

public class HomePagePresenter implements Presenter {
    private MiddlemanConfiguration middlemanConfiguration;

    public HomePagePresenter(MiddlemanConfiguration middlemanConfiguration) {
        this.middlemanConfiguration = middlemanConfiguration;
    }

    public void present(WebContext context) {
        context.renderTemplateHtmlResponse("home",
                with(
                        attribute("proxies", context.getRunningProxies()),
                        attribute("port", middlemanConfiguration.getConfigurationPort())
                )
        );
    }
}
