package com.sca.concurrency;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderCounter implements Counter {
    private final LongAdder adder = new LongAdder();

    @Override
    public void increment() {
        adder.increment();
    }

    @Override
    public void incrementBy(long delta) {
        adder.add(delta);
    }

    @Override
    public long getCount() {
        return adder.sum();
    }
}
