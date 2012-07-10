package middleman.logging;

public class ConsoleApplicationLog implements ApplicationLog {

    public void log(String message, Throwable t) {
        System.out.println(message);
        t.printStackTrace(System.out);
    }

    public void log(String message) {
        System.out.println(message);
    }

    public void trace(String message) {
        System.out.println(message);
    }


}
