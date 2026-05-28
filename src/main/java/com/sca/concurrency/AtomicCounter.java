package com.sca.concurrency;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicCounter implements Counter {
    private final AtomicLong value = new AtomicLong();

    @Override
    public void increment() {
        incrementBy(1);
    }

    @Override
    public void incrementBy(long delta) {
        value.addAndGet(delta);
    }

    @Override
    public long getCount() {
        return value.get();
    }
}
