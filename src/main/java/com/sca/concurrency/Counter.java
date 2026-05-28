package com.sca.concurrency;

public interface Counter {
    void increment();
    void incrementBy(long delta);
    long getCount();
}
