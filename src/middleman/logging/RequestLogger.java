package middleman.logging;

import middleman.model.RequestLogEntry;

import java.util.*;

public class RequestLogger {
    List<RequestLogEntry> entries = Collections.synchronizedList(new ArrayList<RequestLogEntry>());

    public List<RequestLogEntry> getEntries() {
        List<RequestLogEntry> sorted = new ArrayList<RequestLogEntry>(entries);
        Collections.sort(sorted);
        return sorted;
    }

    public void clear() {
        entries.clear();
    }

    public void log(RequestLogEntry logEntry) {
        entries.add(logEntry);
    }
}
