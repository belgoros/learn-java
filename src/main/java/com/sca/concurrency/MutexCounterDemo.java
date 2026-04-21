package com.sca.concurrency;

import java.util.ArrayList;
import java.util.List;

public class MutexCounterDemo {
    public static void main(String[] args) {
        runRace(8, 100_000);
    }

    private static void runRace(int threads, int itersPerThread) {
        var counter = new SynchronizedCounter(0);
        List<Thread> threadsList = new ArrayList<>();
        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < itersPerThread; j++) {
                    counter.inc();
                }
            });
            threadsList.add(thread);
        }

        threadsList.forEach(Thread::start);
        threadsList.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        int expected = threads * itersPerThread;
        System.out.println("Expected: " + expected + ", Actual: " + counter.value());
    }
}
