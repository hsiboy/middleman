package middleman.logging;

import middleman.model.RequestLogEntry;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;


public class EventLoggerUnitTests {
    @Test
    public void canConstructLogger() {
        RequestLogger e = new RequestLogger();
    }

    @Test
    public void constructedLoggerIsEmpty() {
        RequestLogger e = new RequestLogger();
        assertThat(e.getEntries().size(), is(0));
    }

    @Test
    public void canAddAnEntry() {
        RequestLogger logger = new RequestLogger();
        RequestLogEntry logEntry = new RequestLogEntry(0, "GET", "", "", "text/plain", 0, 0, 0, "PROXY", true);
        logger.log(logEntry);
        assertThat(logger.getEntries().size(), is(1));
        assertThat(logger.getEntries().get(0), is(logEntry));
    }
}
