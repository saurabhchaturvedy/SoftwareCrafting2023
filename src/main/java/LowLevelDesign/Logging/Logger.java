package main.java.LowLevelDesign.Logging;

import java.io.Serializable;

import static main.java.LowLevelDesign.Logging.LogManager.doChaining;
import static main.java.LowLevelDesign.Logging.LogManager.registerObservers;

public class Logger implements Cloneable, Serializable {

    private volatile static Logger logger;
    private volatile static AbstractLogger chainOfLogger;
    private volatile static LoggerSubject loggerSubject;


    private Logger() {
        if (logger != null) {
            throw new IllegalStateException("object already exists !!");
        }
    }


    public static Logger getLogger() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                    chainOfLogger = doChaining();
                    loggerSubject = registerObservers();
                }
            }
        }
        return logger;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }


    public Object readResolve() {
        return logger;
    }


    public void info(String message) {
        createLog(1, message);
    }

    public void error(String message) {
        createLog(2, message);
    }

    public void debug(String message) {
        createLog(3, message);
    }


    private void createLog(int level, String msg) {
        chainOfLogger.logMessage(level, msg, loggerSubject);
    }
}
