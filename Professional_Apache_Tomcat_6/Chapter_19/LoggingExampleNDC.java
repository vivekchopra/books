package myPackage;

import org.apache.log4j.Logger;
import org.apache.log4j.NDC;

public class LoggingExampleNDC {
    /* Create a logger for this class */
    private static Logger log = Logger.getLogger(LoggingExampleNDC.class);

    public static void main(String[] args) {
        /* Log messages with varying serverity levels */
        NDC.push("some context here");
        log.trace("This is a trace message");
        log.debug("This is a debug message");
        NDC.push("more context here");
        log.info("This is a info message");
        log.warn("This is a warning message");
        log.error("This is a error message");
        log.fatal("This is a fatal error. All hope is lost!");
        NDC.pop();
        NDC.pop();
    }
}
