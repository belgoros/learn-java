package com.sca.concurrency;

import org.slf4j.Logger;

public class BackgroundTicker {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(BackgroundTicker.class);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread daemenTicker = startDaemon("tick-daemon-" + i, 3_000);
            logger.info("Started daemon thread: {}", daemenTicker.getName());
        }

        for (int i = 0; i < 2; i++) {

            Thread userThread = new Thread(() -> {
                ThreadSleepUtil.safeSleepWithoutThrow(200);
                logger.info("User thread is done sleeping.");
            }, "user-thread-" + i);
            userThread.start();
        }

        System.out.println("Main done.");
    }

    static Thread startDaemon(String name, long timeToSleepMillis) {
        Thread daemenTicker = new Thread(
                BackgroundTicker::makeTicks, "tick-daemon"
        );
        daemenTicker.setDaemon(true);
        daemenTicker.start();
        ThreadSleepUtil.safeSleepWithoutThrow(timeToSleepMillis);
        return daemenTicker;
    }

    private static void makeTicks() {
        while (true) {
            logger.info("Tick");
            ThreadSleepUtil.safeSleepWithoutThrow(1000);
        }
    }
}
