package main.java.LowLevelDesign.Logging.AbstractLoggers;

import main.java.LowLevelDesign.Logging.AbstractLogger;
import main.java.LowLevelDesign.Logging.LoggerSubject;

public class InfoLogger extends AbstractLogger {

    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    public void display(String msg, LoggerSubject loggerSubject) {
        loggerSubject.notifyObservers(1, "INFO MSG : " + msg);
    }
}
