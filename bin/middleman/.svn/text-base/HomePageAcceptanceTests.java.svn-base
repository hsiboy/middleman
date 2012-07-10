package middleman;

import middleman.utils.Block;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePageAcceptanceTests {
    static TestContext testContext;

    @BeforeClass
    public static void setupEnvironment() {
        testContext = TestContext.using(TestAsset.middleman().with(TestAsset.HTMLUnit()));
    }

    @Test
    public void homePageTitleIsS		() {
        testContext.verify(new Block<TestContext>() {
            public void yield(TestContext ctx) {
                ctx.driver().get(TestAsset.middlemanInstance().uri("/"));
                String title = ctx.driver().getTitle();
                assertThat(title, is("Middleman - Server"));
            }
        });
    }

    @Test
    public void homepageContainsDocumentationLink() {
        testContext.verify(new Block<TestContext>() {
            public void yield(TestContext ctx) {
                ctx.driver().get(TestAsset.middlemanInstance().uri("/"));
                WebElement element = ctx.driver().findElement(By.linkText("Middleman documentation"));

                assertThat(element.getAttribute("href"), is("http://localhost:2000/doc/index.html"));
            }
        });
    }

    @Test
    public void homepageContainsLinkToCreateNewProxy() {
        testContext.verify(new Block<TestContext>() {
            public void yield(TestContext ctx) {
                ctx.driver().get(TestAsset.middlemanInstance().uri("/"));
                WebElement element = ctx.driver().findElement(By.linkText("New Proxy"));

                assertThat(element.getAttribute("href"), is("http://localhost:2000/proxy/new"));
            }
        });
    }
}
