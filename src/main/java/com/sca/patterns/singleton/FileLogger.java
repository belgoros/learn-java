package com.sca.patterns.singleton;

public class FileLogger {
    private static FileLogger logger;

    // Prevent clients from using the constructor
    private FileLogger() {
    }

    // Control the accessible (allowed) instances
    public static FileLogger getFileLogger() {
        if (logger == null) {
            logger = new FileLogger();
        }
        return logger;
    }

    public synchronized void log(String msg) {
        System.out.println("From Singleton < Java 1.6: " + msg);
    }
}
