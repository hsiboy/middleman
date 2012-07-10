package middleman;

import middleman.model.RequestLogEntry;
import middleman.utils.Block;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class InMemoryAcceptanceTests {
    @Test
    public void shouldLogTraffic() {
        TestContext.using(TestAsset.middlemanPassingThrough()).verify(new Block<TestContext>() {

            public void yield(TestContext item) {
                TestAsset.requestFromProxy("http://www.google.com/");

                Iterable<RequestLogEntry> logs = TestAsset.middlemanInstance().getLogsFor("TestAsset.middlemanPassingThrough");

                RequestLogEntry entry = logs.iterator().next();
                assertThat(entry.getHost(), is("www.google.com:80"));
                assertThat(entry.getResponseContentType(), is("text/plain"));
            }
        });
    }
}
