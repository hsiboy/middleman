package middleman;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import middleman.proxy.DummyHttpServer;
import middleman.proxy.DummyHttpServer.ReceivedRequest;
import middleman.utils.Block;

import org.junit.BeforeClass;
import org.junit.Test;


public class RequestModificationFunctionalTests {
	static TestContext testContext;

	@BeforeClass
	public static void setupEnvironment() {
		testContext = TestContext.using(TestAsset.middlemanPassingThrough().with(TestAsset.firefoxWithMiddlemanProxy()));
	}

	@Test
	public void shouldSetRequestHeaderIfSpecifiedThroughApi() {

		testContext.verify(new Block<TestContext>() {
			public void yield(TestContext ctx)  {
				TestAsset.middlemanInstance().api().addRequestModifier().addingHeader("HeaderAbc", "xyz");

				DummyHttpServer proxiedServer = new DummyHttpServer(8082).start();

				String proxiedPort = "8082";
				TestAsset.requestFromProxy("http://localhost:" + proxiedPort + "/");

				ReceivedRequest firstReceivedRequest = proxiedServer.receivedRequests().get(0);
				
				System.out.print(firstReceivedRequest);
				System.out.print(firstReceivedRequest.getUrl());
				System.out.print(firstReceivedRequest.getHeaders().getFirst("HeaderAbc"));

				assertThat(firstReceivedRequest, is(notNullValue()));
				assertThat(firstReceivedRequest.getUrl(), containsString(proxiedPort));
				assertThat(firstReceivedRequest.getHeaders().getFirst("HeaderAbc"), is("xyz"));
			}
		});

	}

	private static void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
