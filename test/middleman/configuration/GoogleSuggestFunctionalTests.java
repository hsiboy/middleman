package middleman.configuration;

import java.io.File;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


public class GoogleSuggestFunctionalTests {

    public static void main(String[] args) {
        new GoogleSuggestFunctionalTests().spinGoogle();
    }

    @Ignore @Test
    public void spinGoogle() {
        WebDriver driver = new FirefoxDriver();
                
        try {
            // The Firefox driver supports javascript
            driver = getFirefoxDriver();

            // Go to the Google Suggest home page
            driver.get("http://www.google.co.uk/");
            
            WebElement element = driver.findElement(By.name("q"));
            element.sendKeys("Cheese!\n"); // send also a "\n"
            element.submit();

            // wait until the google page shows the result
            List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));

            
         // this are all the links you like to visit
            for (WebElement webElement : findElements)
            {
                System.out.println(webElement.getAttribute("href"));
            }
            
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    private FirefoxDriver getFirefoxDriver() {
        
        String basedir = System.getProperty("user.dir");
    	File firefoxProfileFolder = new File(basedir + "/test/middleman/firefoxprofile");
    	FirefoxProfile profile = new FirefoxProfile(firefoxProfileFolder);
        profile.setPreference("extensions.checkCompatibility", false);
        // profile.setPreference("network.proxy.http", "proxy");
        // profile.setPreference("network.proxy.http_port", 8080);
        // profile.setPreference("network.proxy.type", 1);
        // profile.setPreference("network.proxy.no_proxies_on", "localhost");
        
        return new FirefoxDriver(profile);
    }
}
