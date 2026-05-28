package com.sca.concurrency;

public class UnsafeCounter implements Counter {
    private long count;

    @Override
    public void increment() {
        count++;
    }

    @Override
    public void incrementBy(long delta) {
        count += delta;
    }

    @Override
    public long getCount() {
        return count;
    }
}
