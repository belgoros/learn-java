package com.sca.concurrency;

public class SynchronizedCounter implements Counter {
    private long count;

    public SynchronizedCounter(long count) {
        this.count = count;
    }

    @Override
    public synchronized void inc() {
        count++;
    }

    @Override
    public long value() {
        return count;
    }
}
