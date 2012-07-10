package middleman;

import middleman.api.MiddlemanApi;
import middleman.configuration.MiddlemanConfiguration;
import middleman.logging.ApplicationLog;
import middleman.logging.ConsoleApplicationLog;
import middleman.model.RequestLogEntry;
import middleman.server.MiddlemanServer;

public class Application {

    private MiddlemanServer server;

    public static void main(String[] args) {
        Application middleman = new Application();
        middleman.run(new String[]{"-port", "2000", "middleman.config"});
    }

    public void run(String args[]) {
        ApplicationLog logger = new ConsoleApplicationLog();
        MiddlemanConfiguration configuration = new MiddlemanConfiguration(logger);
        configuration.parseArgs(args);
        server = new MiddlemanServer(logger);
        server.start(configuration);
    }

    public MiddlemanApi api() {
        return server.api(); 
    }

    public Iterable<RequestLogEntry> getLogsFor(String proxyName) {
        return server.getLogsFor(proxyName);
    }

    public void clearLogsFor(String proxyName) {
        server.clearLogsFor(proxyName);
    }

    public void stop() {
        server.stop();
    }
}
