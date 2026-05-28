package com.sca.concurrency;

import java.util.ArrayList;
import java.util.List;

public final class CounterLoad {
    public static void runLoad(Counter counter, int threadsCount, int iterationsPerThread) {

        List<Thread> threadsList = new ArrayList<>(threadsCount);
        for (int i = 0; i < threadsCount; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < iterationsPerThread; j++) {
                    counter.increment();
                }
            });
            threadsList.add(thread);
        }

        long startTime = System.nanoTime();
        threadsList.forEach(Thread::start);
        threadsList.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        int expected = threadsCount * iterationsPerThread;
        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;

        Logger.log("%s: expected=%d, actual=%d, timeMs=%d",
                counter.getClass().getSimpleName(),
                expected,
                counter.getCount(),
                durationMs
        );
    }
}
