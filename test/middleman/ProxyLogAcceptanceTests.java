package middleman;


import middleman.utils.Block;
import org.junit.BeforeClass;
import org.junit.Test;

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
    public void returnsSomeLogs() {
        testContext.verify(new Block<TestContext>() {
            public void yield(TestContext ctx) {

                TestAsset.requestFromProxy("http://www.google.com/");

                ctx.driver().get(TestAsset.middlemanInstance().uri("/TestAsset.middlemanPassingThrough/log"));
                String title = ctx.driver().getTitle();
                assertThat(title, is("Requests Log - TestAsset.middlemanPassingThrough | Middleman"));
                assertThat(ctx.driver().getPageSource(), containsString("google"));
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

                assertThat("Should have got host in this xml " + response.toString(),
                        response.asXml().get("//host[1]"), containsString("google"));
            }
        });
    }

}
