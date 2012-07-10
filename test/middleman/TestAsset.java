package middleman;

import middleman.configuration.*;
import middleman.logging.ConsoleApplicationLog;
import middleman.server.MiddlemanServer;
import middleman.server.UriMatchers;
import middleman.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;

import java.util.ArrayList;
import java.util.List;

abstract class TestAsset {
    public static final int PROXY_PORT = 2001;
    protected List<TestAsset> children;
    protected static MiddlemanServer middlemanServer;

    public static TestAsset middleman() {
        ConsoleApplicationLog log = new ConsoleApplicationLog();
        return middlemanWithConfig(new MiddlemanConfiguration(log), log);
    }
    
    public static TestAsset middlemanWithConfig(final MiddlemanConfiguration config, final ConsoleApplicationLog log) {
        return new TestAsset() {

            @Override
            public void itemConstruct(TestContext ctx) {
                middlemanServer = new MiddlemanServer(log);

                new Thread() {
                    @Override
                    public void run() {
                        super.run();  
                        middlemanServer.start(config);
                    }
                }.start();
                Utils.sleep(400);
            }

            @Override
            public void itemClose() {
                if (middlemanServer != null) {
                    middlemanServer.stop();
                }
            }
        };
    }

    public static TestAsset middlemanPassingThrough() {
        ConsoleApplicationLog log = new ConsoleApplicationLog();
        MiddlemanConfiguration config = new MiddlemanConfiguration(log, 2020);

        ProxyConfig proxyConfig = new ProxyConfig();
        proxyConfig.setPort(PROXY_PORT);
        proxyConfig.setName("TestAsset.middlemanPassingThrough");
        proxyConfig.add(new StubResponse(UriMatchers.patternMatcher("www.google.com"), ""));
        config.add(proxyConfig);
        return middlemanWithConfig(config, log);
    }

    public static TestAsset firefox() {
        return FirefoxAsset.createFirefoxWithoutProxy();
    }

    public static TestAsset firefoxWithMiddlemanProxy() {
        return FirefoxAsset.createFirefoxWithProxy();
    }

    public static TestAsset HTMLUnit() {
        return new TestAsset() {
            WebDriver driver;

            @Override
            public void itemConstruct(TestContext ctx) {
                System.out.println("Starting htmlunit");
                driver = new HtmlUnitDriver();
                ctx.driver = driver;
            }

            @Override
            public void itemClose() {
                if (driver != null) {
                    driver.quit();
                }
                driver = null;
            }
            
            @Override
            public void close(){
            	itemClose();
            }
        };
    }

    public static TestAsset safari() {
        return new TestAsset() {
            WebDriver driver;

            @Override
            public void itemConstruct(TestContext ctx) {
                FirefoxProfile profile = new FirefoxProfile();

                profile.setPreference("network.proxy.http", "localhost");
                profile.setPreference("network.proxy.http_port", 2001);
                profile.setPreference("network.proxy.type", 1);

                driver = new SafariDriver();
                ctx.driver = driver;
            }

            @Override
            public void itemClose() {
            	driver.close();
            	driver.quit();
                driver = null;
            }
        };
    }

    TestAsset() {
        this.children = new ArrayList<TestAsset>();
    }

    protected abstract void itemConstruct(TestContext ctx);

    public void construct(TestContext ctx) {
        itemConstruct(ctx);
        for (TestAsset child : children) {
            child.construct(ctx);
        }
    }

    protected abstract void itemClose();

    public void close() {
        for (TestAsset child : children) {
            child.close();
        }
        itemClose();
    }

    public TestAsset with(TestAsset child) {
        this.children.add(child);
        return this;
    }

    public static MiddlemanServer middlemanInstance() {
        return middlemanServer;
    }

    public static HttpResponse requestFromMiddleman(String url) {
        return new HttpRequest(middlemanInstance().uri(url)).makeRequest();

    }

    public static void requestFromProxy(String target) {
        new HttpRequest(target, "localhost", PROXY_PORT).makeRequest();
    }
}
