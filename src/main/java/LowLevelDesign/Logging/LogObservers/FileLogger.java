package main.java.LowLevelDesign.Logging.LogObservers;

import main.java.LowLevelDesign.Logging.LogObserver;

public class FileLogger implements LogObserver {
    @Override
    public void log(String msg) {
        System.out.println(" FILE MSG :" + msg);
    }
}