package com.sca.concurrency;

import java.security.SecureRandom;

public final class ThreadSleepUtil {
    private static final SecureRandom RANDOM = new SecureRandom();

    private ThreadSleepUtil() {
    }


    /**
     * Safely sleeps for the required time in ms, when interrupted - returns a flag without throwing InterruptedException.
     *
     * @param millis sleep time in milliseconds
     */
    public static void safeSleepWithoutThrow(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserve interrupt status
        }
    }

    /**
     * Безопасно спит указанное время
     * При прерывании возвращает флаг, не проглатывая событие.
     * Добавляет случайную задержку
     */
    public static void safeSleepWithJitter(long ms) {
        if (ms <= 0) {
            return;
        }
        try {
            var jitter = RANDOM.nextLong(ms / 2);
            if (RANDOM.nextBoolean()) {
                jitter *= -1;
            }
            Thread.sleep(ms + jitter);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Безопасно спит случайное время в диапазоне
     * При прерывании возвращает флаг, не проглатывая событие.
     */
    public static void safeSleepRandomMillis(
            long lowerBound,
            long upperBound
    ) {
        try {
            var sleepMillis = RANDOM.nextLong(lowerBound, upperBound);
            Thread.sleep(sleepMillis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
