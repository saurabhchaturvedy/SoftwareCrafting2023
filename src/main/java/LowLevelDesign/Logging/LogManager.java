package main.java.LowLevelDesign.Logging;

import main.java.LowLevelDesign.Logging.AbstractLoggers.DebugLogger;
import main.java.LowLevelDesign.Logging.AbstractLoggers.ErrorLogger;
import main.java.LowLevelDesign.Logging.AbstractLoggers.InfoLogger;
import main.java.LowLevelDesign.Logging.LogObservers.DisplayLogger;
import main.java.LowLevelDesign.Logging.LogObservers.FileLogger;

public class LogManager {


    public static AbstractLogger doChaining() {
        AbstractLogger infoLogger = new InfoLogger(1);
        AbstractLogger errorLogger = new ErrorLogger(2);
        infoLogger.setNextAbstractLogger(errorLogger);
        AbstractLogger debugLogger = new DebugLogger(3);
        errorLogger.setNextAbstractLogger(debugLogger);
        return infoLogger;

    }

    public static LoggerSubject registerObservers() {
        LoggerSubject loggerSubject = new LoggerSubject();
        DisplayLogger displayLogger = new DisplayLogger();
        loggerSubject.addObserver(1, displayLogger);
        loggerSubject.addObserver(2, displayLogger);
        loggerSubject.addObserver(3, displayLogger);
        FileLogger fileLogger = new FileLogger();
        loggerSubject.addObserver(3, fileLogger);
        return loggerSubject;
    }
}
