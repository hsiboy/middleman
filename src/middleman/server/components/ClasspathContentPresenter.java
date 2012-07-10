package middleman.server.components;

import middleman.framework.Presenter;
import middleman.server.MiddlemanServer;
import middleman.server.WebContext;

import java.io.IOException;
import java.io.InputStream;

public class ClasspathContentPresenter implements Presenter {
    public void present(WebContext context) {
        InputStream stream = null;
        try {
            stream = MiddlemanServer.class.getResourceAsStream(context.getRequestUri().getPath());

            context.renderResponse(stream);
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
