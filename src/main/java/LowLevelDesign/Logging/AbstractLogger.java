package main.java.LowLevelDesign.Logging;

public abstract class AbstractLogger {

    protected int level;
    AbstractLogger abstractLogger;

    public void setNextAbstractLogger(AbstractLogger abstractLogger) {
        this.abstractLogger = abstractLogger;
    }

    public void logMessage(int level, String msg, LoggerSubject loggerSubject) {
        if (this.level == level) {
            display(msg, loggerSubject);
        }

        if (abstractLogger != null) {
            abstractLogger.logMessage(level, msg, loggerSubject);
        }
    }

    public abstract void display(String msg, LoggerSubject loggerSubject);
}
