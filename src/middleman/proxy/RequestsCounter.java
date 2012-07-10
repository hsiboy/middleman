package middleman.proxy;

public class RequestsCounter {
    private int runningRequestrsCounter;
    private Long lastRequestTimestamp = now();

    private RequestsCounter() {
        runningRequestrsCounter = 0;
    }

    private static class SingletonHolder {
        private static final RequestsCounter INSTANCE = new RequestsCounter();
    }

    public static RequestsCounter getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public synchronized void started(){
        runningRequestrsCounter++;
        if (lastRequestTimestamp != null) {
            lastRequestTimestamp = null;
        }
    }

    public synchronized void finished(){
        if (--runningRequestrsCounter < 1) {
            lastRequestTimestamp = now();
        }
    }

    public synchronized int getNumberOfRunningRequests(){
        return runningRequestrsCounter;
    }

    public synchronized long getMillisecondsWithoutRunningRequest() {
        if (lastRequestTimestamp == null) {
            return 0;
        }
        return now() - lastRequestTimestamp;
    }

    private Long now() {
        return System.currentTimeMillis();
    }
}
