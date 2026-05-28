package com.sca.concurrency;

public class SynchronizedCounter implements Counter {
    private long count;


    @Override
    public synchronized void increment() {
        count++;
    }

    @Override
    public synchronized void incrementBy(long delta) {
            count += delta;
    }

    @Override
    public synchronized long getCount() {
        return count;
    }
}
