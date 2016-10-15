package myPackage;

import org.apache.log4j.Logger;

public class LoggingExample {
    /* Create a logger for this class */
    private static Logger log = Logger.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        /* Log messages with varying serverity levels */
        log.trace("This is a trace message");
        log.debug("This is a debug message");
        log.info("This is an info message");
        log.warn("This is a warning message");
        log.error("This is an error message");
        log.fatal("This is a fatal error. All hope is lost!");
    }
}
