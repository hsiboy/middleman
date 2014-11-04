package middleman;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import middleman.utils.Block;

import org.junit.Test;


public class HomePageFunctionalTests {

    @Test
    public void canViewHomepage() {
        TestContext.using(TestAsset.middleman().with(TestAsset.firefox())).verify(new Block<TestContext>() {
            public void yield(TestContext ctx) {
                ctx.driver().get(TestAsset.middlemanInstance().uri("/"));
                assertThat(ctx.driver().getTitle(), is("Home | Middleman - Dynamic Proxy Server"));
            }
        });
    }
}
