package com.sca.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public final class LockableResource {
    private final String name; // Например: "Name-A" / "Name-B"
    private final int id; // Для глобального порядка (фикс №1)
    private final ReentrantLock lock = new ReentrantLock();
    private final Object monitor = new Object(); // Для synchronized-блоков

    public LockableResource(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String name() {
        return name;
    }

    public int id() {
        return id;
    }

    public ReentrantLock reentrantLock() {
        return lock;
    }

    public Object monitor() {
        return monitor;
    }

    @Override
    public String toString() {
        return "Resource-" + name;
    }
}
