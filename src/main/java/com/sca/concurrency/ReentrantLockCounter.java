package com.sca.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter implements Counter {
    private final Lock lock = new ReentrantLock(false);
    private long value;

    @Override
    public void increment() {
        incrementBy(1);
    }

    @Override
    public void incrementBy(long delta) {
        lock.lock();
        try {
            value += delta;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public long getCount() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }
}
