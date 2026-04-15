package AvajLauncher.Observer;

import java.io.File;

public class ConcreteSubscriberLogOpen implements Subscriber {
    private File log;

    public ConcreteSubscriberLogOpen(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Save to log " + log + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }
}
