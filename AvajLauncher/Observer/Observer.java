package AvajLauncher.Observer;

import java.io.File;

public class Observer
{
    public static void observer(String[] args)
    {
    	ConcreteSubscriberEmailNotification ConcreteSubscriber1 = new ConcreteSubscriberEmailNotification("admin@example.com");
    	ConcreteSubscriberLogOpen ConcreteSubscriber2 = new ConcreteSubscriberLogOpen("file.txt");
    	
    	Publisher publisher = new Publisher("open", "save");
        publisher.subscribe("open", ConcreteSubscriber1);
        publisher.subscribe("save", ConcreteSubscriber2);
        		
        try
        {
        	File file = new File("file.txt");	
            publisher.notify("open", file);
            publisher.notify("save", file);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}