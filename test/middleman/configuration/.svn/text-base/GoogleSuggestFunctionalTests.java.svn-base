package middleman.configuration;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class GoogleSuggestFunctionalTests {

    public static void main(String[] args) {
        new GoogleSuggestFunctionalTests().spinGoogle();
    }

    @Test
    public void spinGoogle() {
        WebDriver driver = null;// = new FirefoxDriver();
        try {
            // The Firefox driver supports javascript
            driver = getFirefoxDriver();

            // Go to the Google Suggest home page
            driver.get("http://www.google.com/webhp?complete=1&hl=en");

            // Enter the query string "Cheese"
            WebElement query = driver.findElement(By.name("q"));
            query.sendKeys("Cheese");

            // Sleep until the div we want is visible or 5 seconds is over
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {

                WebElement resultsDiv = (WebElement) driver.findElement(By.className("gsib_a"));
                try {
                // If results have been returned, the results are displayed in a drop down.
                if (resultsDiv.isDisplayed()) {
                    break;
                }
                } catch (NoSuchElementException e) {}
                
            }

            // And now list the suggestions
            List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_e']"));

            for (WebElement suggestion : allSuggestions) {
                System.out.println(suggestion.getText());
            }
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    private FirefoxDriver getFirefoxDriver() {
        System.out.println("getFirefoxDriver()");
        
    	FirefoxProfile profile = new FirefoxProfile();
        // profile.setPreference("network.proxy.http", "proxy");
        // profile.setPreference("network.proxy.http_port", 8080);
        // profile.setPreference("network.proxy.type", 1);
        // profile.setPreference("network.proxy.no_proxies_on", "localhost");
        
        return new FirefoxDriver(profile);
    }
}
