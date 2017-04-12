package com.sca.logging;

import org.apache.log4j.*;

import java.io.IOException;

public class LogExample {
    public static void main(String[] args) {
        String[] names = {"toto", "yoyo", "zozo"};
        Logger logger = Logger.getLogger("com.loging");
        for (String name : names) {
            try {
                PatternLayout layout = new PatternLayout(
                        "%d %-5p %c - %F:%L - %m%n");
                Appender appender = null;
                if (name.equals("toto")) {
                    appender = new FileAppender(new SimpleLayout(), name
                            + ".log");
                } else {
                    appender = new ConsoleAppender(layout);
                }
                logger.addAppender(appender);
                logger.info("Démarrage");
                logger.log(Level.INFO, "got name: " + name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
