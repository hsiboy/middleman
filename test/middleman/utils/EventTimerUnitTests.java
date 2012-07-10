package middleman.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class EventTimerUnitTests {

    @Test
    public void eventTimerStartsOnConstruction() {
        EventTimer timer = new EventTimer();
        assertThat(timer.startTime() != 0, is(true));
    }

    @Test
    public void eventTimerMeasuresElapsedTime() throws Exception {
        EventTimer timer = new EventTimer();
        Thread.sleep(50);
        assertThat(timer.elapsed() != 0, is(true));
    }

}
