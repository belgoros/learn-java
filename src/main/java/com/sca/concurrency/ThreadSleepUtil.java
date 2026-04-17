package com.sca.concurrency;

public final class ThreadSleepUtil {
    private ThreadSleepUtil() {
    }


    /**
     * Safely sleeps for the required time in ms, when interrupted - returns a flag without throwing InterruptedException.
     * @param millis sleep time in milliseconds
     */
    public static void safeSleepWithoutThrow(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserve interrupt status
        }
    }
}
