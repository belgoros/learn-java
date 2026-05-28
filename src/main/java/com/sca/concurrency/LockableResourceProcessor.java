package com.sca.concurrency;

public interface LockableResourceProcessor {
    void processResources(LockableResource r1, LockableResource r2);
}
