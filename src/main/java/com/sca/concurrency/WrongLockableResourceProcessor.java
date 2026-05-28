package com.sca.concurrency;

public class WrongLockableResourceProcessor implements LockableResourceProcessor {
    @Override
    public void processResources(LockableResource r1, LockableResource r2) {
        Logger.log("starting work r1=%s r2=%s", r1, r2);

        synchronized (r1.monitor()) {
            Logger.log("acquired first (monitor) %s", r1);
            Logger.log("attempting second (monitor) %s", r2);
            synchronized (r2.monitor()) {
                Logger.log("inside critical section with %s and %s", r1, r2);
            }
            Logger.log("released second (monitor) %s", r2);
        }
        Logger.log("released first (monitor) %s", r1);
    }
}
