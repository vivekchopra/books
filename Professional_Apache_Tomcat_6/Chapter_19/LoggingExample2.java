package myPackage;

import java.util.logging.Logger;


public class LoggingExample2 {
    /* Create a logger for this class */
    private static Logger log = Logger.getLogger(LoggingExample2.class.getName());

    public static void main(String[] args) {
        /* Log messages with varying severity levels */
        log.finer("This is a trace message");
        log.fine("This is a debug message");
        log.info("This is an info message");
        log.warning("This is a warning message");
        log.severe("This is a fatal/error message. All hope might be lost");
    }
}
