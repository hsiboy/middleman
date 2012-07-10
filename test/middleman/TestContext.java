package middleman;

import middleman.utils.Block;
import org.openqa.selenium.WebDriver;

class TestContext {
    TestAsset asset;
    WebDriver driver;

    public TestContext(TestAsset asset) {
        this.asset = asset;
    }

    public static TestContext using(TestAsset asset) {
        return new TestContext(asset);
    }

    public void verify(Block<TestContext> block) {
        try {
            asset.construct(this);

            block.yield(this);
        } finally {
           asset.close();
        }
    }

    public WebDriver driver() {
        return driver;
    }
}
