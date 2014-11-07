package middleman;


import middleman.utils.Block;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class ProxyLogAcceptanceTests {
    static TestContext testContext;

    @BeforeClass
    public static void setupEnvironment() throws IOException {
        testContext = TestContext.using(TestAsset.middlemanPassingThrough().with(TestAsset.HTMLUnit()));
    }

    @Test
    public void returnsSomeLogsInHtml() {
        testContext.verify(new Block<TestContext>() {
            public void yield(TestContext ctx) {

                TestAsset.requestFromProxy("http://www.google.com/");

                ctx.driver().get(TestAsset.middlemanInstance().uri("/TestAsset.middlemanPassingThrough/log"));
                String title = ctx.driver().getTitle();
                assertThat(title, is("Requests Log - TestAsset.middlemanPassingThrough | Middleman"));
                
                assertThat("Should have got host Google in this page " + ctx.driver().getPageSource(),
                		ctx.driver().getPageSource(), containsString("google"));
                
		        assertThat("Should have 'Refresh Log' link/button in this page" + ctx.driver().getPageSource(),
		        		ctx.driver().findElement(By.linkText("Refresh Log")).getAttribute("href"), 
		        		containsString("/TestAsset.middlemanPassingThrough/log"));
		        
		        
		        assertThat("Should have 'Download this log as CSV' link/button in this page" + ctx.driver().getPageSource(),
		        		ctx.driver().findElement(By.linkText("Download this log as CSV")).getAttribute("href"), 
		        		containsString("/TestAsset.middlemanPassingThrough/log/csv"));
		        
		        assertThat("Should have 'View XML' link/button in this page" + ctx.driver().getPageSource(),
		        		ctx.driver().findElement(By.linkText("View XML")).getAttribute("href"), 
		        		containsString("/TestAsset.middlemanPassingThrough/log/xml"));
		        
                assertThat("Should have 'View JSON' link/button in this page" + ctx.driver().getPageSource(),
                		ctx.driver().findElement(By.linkText("View JSON")).getAttribute("href"), 
                		containsString("/TestAsset.middlemanPassingThrough/log/json"));
                
                assertThat("Should have 'View JSONP' link/button in this page" + ctx.driver().getPageSource(),
                		ctx.driver().findElement(By.linkText("View JSONP")).getAttribute("href"), 
                		containsString("/TestAsset.middlemanPassingThrough/log/jsonp"));
                
            }
        });
    }
    
    @Test
    public void returnsSomeLogsInHtmlWithTrailingSlash() {
        testContext.verify(new Block<TestContext>() {
            public void yield(TestContext ctx) {

                TestAsset.requestFromProxy("http://www.google.com/");

                ctx.driver().get(TestAsset.middlemanInstance().uri("/TestAsset.middlemanPassingThrough/log/"));
                String title = ctx.driver().getTitle();
                assertThat(title, is("Requests Log - TestAsset.middlemanPassingThrough | Middleman"));
                
            }
        });
    }

    @Test
    public void returnsLogsInCsv() {
        testContext.verify(new Block<TestContext>() {
            public void yield(TestContext ctx) {

                TestAsset.requestFromProxy("http://www.google.com/");

                HttpResponse response = TestAsset.requestFromMiddleman("/TestAsset.middlemanPassingThrough/log/csv");
                assertThat(response.containsHeader("Content-type", "application/vnd.ms-excel"), is(true));
                assertThat(response.containsHeader("Content-disposition", "attachment; filename=proxy-logs.csv"), is(true));
                
                ctx.driver().get(TestAsset.middlemanInstance().uri("/TestAsset.middlemanPassingThrough/log/json"));

                assertThat("Should have got host Google in this json " + ctx.driver().getPageSource(),
                		ctx.driver().getPageSource(), containsString("google"));
            }
        });
    }

    @Test
    public void returnsLogsInXml() {
        testContext.verify(new Block<TestContext>() {
            public void yield(TestContext ctx) {

                TestAsset.requestFromProxy("http://www.google.com/?param1=abc&param2=xyz");

                HttpResponse response = TestAsset.requestFromMiddleman("/TestAsset.middlemanPassingThrough/log/xml");
                assertThat(response.containsHeader("Content-type", "text/xml"), is(true));

                assertThat("Should have got host Google in this xml " + response.toString(),
                        response.asXml().get("//host[1]"), containsString("google"));
            }
        });
    }
    
    @Test
    public void returnsLogsInJson() {
        testContext.verify(new Block<TestContext>() {
            public void yield(TestContext ctx) {

                TestAsset.requestFromProxy("http://www.google.com/?param1=abc&param2=xyz123");
                
                HttpResponse response = TestAsset.requestFromMiddleman("/TestAsset.middlemanPassingThrough/log/json");
                assertThat(response.containsHeader("Content-type", "application/json"), is(true));
                
                ctx.driver().get(TestAsset.middlemanInstance().uri("/TestAsset.middlemanPassingThrough/log/json"));

                assertThat("Should have got host Google in this json " + ctx.driver().getPageSource(),
                		ctx.driver().getPageSource(), containsString("google"));
            }
        });
    }
    
    @Test
    public void returnsLogsInJsonP() {
        testContext.verify(new Block<TestContext>() {
            public void yield(TestContext ctx) {

                TestAsset.requestFromProxy("http://www.google.com/?param1=abc&param2=xyz123");
                
                HttpResponse response = TestAsset.requestFromMiddleman("/TestAsset.middlemanPassingThrough/log/jsonp");
                assertThat(response.containsHeader("Content-type", "application/javascript"), is(true));
                
                ctx.driver().get(TestAsset.middlemanInstance().uri("/TestAsset.middlemanPassingThrough/log/jsonp"));

                assertThat("Should have json in js method call for this jsonp " + ctx.driver().getPageSource(),
                		ctx.driver().getPageSource(), containsString("mm_jsonp_callback("));
                
                assertThat("Should have got host Google in this jsonp " + ctx.driver().getPageSource(),
                		ctx.driver().getPageSource(), containsString("google"));
            }
        });
    }

}
