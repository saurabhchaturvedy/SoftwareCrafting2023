package main.java.LowLevelDesign.Logging.AbstractLoggers;

import main.java.LowLevelDesign.Logging.AbstractLogger;
import main.java.LowLevelDesign.Logging.LoggerSubject;

public class DebugLogger extends AbstractLogger {

    public DebugLogger(int level)
    {
        this.level=level;
    }

    @Override
    public void display(String msg, LoggerSubject loggerSubject) {
        loggerSubject.notifyObservers(3, "DEBUG MSG : " + msg);
    }
}
