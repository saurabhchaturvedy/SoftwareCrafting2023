package main.java.LowLevelDesign.Logging;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        logger.info("this is an info");
        logger.debug("this is a debug");
        logger.error("this is an error");
    }

}
