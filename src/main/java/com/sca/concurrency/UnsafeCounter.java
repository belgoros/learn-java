package com.sca.concurrency;

public class UnsafeCounter implements Counter {
    private long count;

    public UnsafeCounter(long count) {
        this.count = count;
    }

    @Override
    public void inc() {
        count++;
    }

    @Override
    public long value() {
        return count;
    }
}
