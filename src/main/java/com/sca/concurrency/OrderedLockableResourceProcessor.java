package com.sca.concurrency;

public final class OrderedLockableResourceProcessor implements LockableResourceProcessor {

    @Override
    public void processResources(
            LockableResource r1,
            LockableResource r2
    ) {
        LockableResource first = r1.id() < r2.id() ? r1 : r2;
        LockableResource second = r1.id() < r2.id() ? r2 : r1;

        Logger.log("ordered acquire: first=%s second=%s", first, second);
        synchronized (first.monitor()) {
            Logger.log("acquired first (monitor) %s", first);
            synchronized (second.monitor()) {
                Logger.log("acquired second (monitor) %s", second);
                Logger.log("inside critical section with %s and %s", first, second);
            }
            Logger.log("released second (monitor) %s", second);
        }
        Logger.log("released first (monitor) %s", first);
    }
}
