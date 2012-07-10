package middleman;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

final class FirefoxAsset extends TestAsset {

    WebDriver driver;
    private FirefoxProfile firefoxProfile;

    public FirefoxAsset(FirefoxProfile firefoxProfile) {
        this.firefoxProfile = firefoxProfile;
    }

    public FirefoxAsset() {
        this(null);
    }

    @Override
    public void itemConstruct(TestContext ctx) {
        System.out.println("Starting firefox");

        if (firefoxProfile == null) {
            driver = new FirefoxDriver();
        }
        else {
            driver = new FirefoxDriver(firefoxProfile);
        }
        ctx.driver = driver;
    }
    
    @Override
    public void close(){
    	itemClose();
    }

    @Override
    public void itemClose() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    protected static TestAsset createFirefoxWithoutProxy() {
        return new FirefoxAsset();
    }

    protected static FirefoxProfile firefoxProfileToUseLocalProxy() {
        FirefoxProfile profile = new FirefoxProfile();
    
        profile.setPreference("network.proxy.http", "localhost");
        profile.setPreference("network.proxy.no_proxies_on", "");
        profile.setPreference("network.proxy.http_port", PROXY_PORT);
        profile.setPreference("network.proxy.type", 1);

        return profile;
    }

    public static TestAsset createFirefoxWithProxy() {
        return new FirefoxAsset(firefoxProfileToUseLocalProxy());
    }
}