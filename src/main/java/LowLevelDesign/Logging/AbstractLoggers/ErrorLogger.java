package main.java.LowLevelDesign.Logging.AbstractLoggers;

import main.java.LowLevelDesign.Logging.AbstractLogger;
import main.java.LowLevelDesign.Logging.LoggerSubject;

public class ErrorLogger extends AbstractLogger {

   public ErrorLogger(int level)
    {
        this.level=level;
    }

    @Override
    public void display(String msg, LoggerSubject loggerSubject) {
        loggerSubject.notifyObservers(2, "ERROR MSG : " + msg);
    }
}
