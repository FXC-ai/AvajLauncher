package AvajLauncher.Observer;

import java.io.File;

public interface Subscriber
{
    void update(String eventType, File file);
}
