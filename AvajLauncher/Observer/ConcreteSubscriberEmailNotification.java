package AvajLauncher.Observer;

import java.io.File;

public class ConcreteSubscriberEmailNotification implements Subscriber
{
    private String email;

    public ConcreteSubscriberEmailNotification(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Email to " + email + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }
}