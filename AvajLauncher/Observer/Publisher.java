package AvajLauncher.Observer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Publisher {
    Map<String, List<Subscriber>> subscribers = new HashMap<>();

    public Publisher(String... operations) {
        for (String operation : operations) {
            this.subscribers.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, Subscriber listener) {
        List<Subscriber> users = subscribers.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, Subscriber listener) {
        List<Subscriber> users = subscribers.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, File file) {
        List<Subscriber> users = subscribers.get(eventType);
        for (Subscriber listener : users) {
            listener.update(eventType, file);
        }
    }
}
