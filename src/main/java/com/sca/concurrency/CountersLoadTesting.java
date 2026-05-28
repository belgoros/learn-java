package com.sca.concurrency;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CountersLoadTesting {
    private int threadsCount;
    private int iterationsPerThread;

    public static void main(String[] args) {

        int threads = 8;
        int itersPerThread = 250_000;
        Logger.log("=== Load test: threads=%d, iters=%d ===\n", threads, itersPerThread);
        CounterLoad.runLoad(new UnsafeCounter(), threads, itersPerThread);
        CounterLoad.runLoad(new SynchronizedCounter(), threads, itersPerThread);
        CounterLoad.runLoad(new AtomicCounter(), threads, itersPerThread);
        CounterLoad.runLoad(new ReentrantLockCounter(), threads, itersPerThread);
        CounterLoad.runLoad(new LongAdderCounter(), threads, itersPerThread);

        threads = 32;
        itersPerThread = 1_000_000;
        System.out.println();
        Logger.log("=== Heavy load test: threads=%d, iters=%d ===\n", threads, itersPerThread);
        CounterLoad.runLoad(new AtomicCounter(), threads, itersPerThread);
        CounterLoad.runLoad(new LongAdderCounter(), threads, itersPerThread);
    }
}
