package com.sca.concurrency;

import java.util.concurrent.TimeUnit;

public final class TryLockLockableResourceProcessor implements LockableResourceProcessor {


    public TryLockLockableResourceProcessor() {
    }

    @Override
    public void processResources(
            LockableResource r1,
            LockableResource r2
    ) {
        var firstLock = r1.reentrantLock();
        var secondLock = r2.reentrantLock();

        while (true) {
            Logger.log("Пытаемся захватить первый лок %s", r1);

            try {
                if (!firstLock.tryLock(10, TimeUnit.MILLISECONDS)) {
                    Logger.log("Не удалось взять лок resource = %s", r1.id());
                    ThreadSleepUtil.safeSleepRandomMillis(5, 15);
                    continue;
                }

                if (!secondLock.tryLock(10, TimeUnit.MILLISECONDS)) {
                    Logger.log("Не удалось взять лок resource = %s", r2.id());
                    firstLock.unlock();
                    ThreadSleepUtil.safeSleepRandomMillis(5, 15);
                    continue;
                }

                Logger.log("Внутри критической секции %s и %s", r1.id(), r2.id());
                return;

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            } finally {
                if (firstLock.isHeldByCurrentThread()) {
                    firstLock.unlock();
                }
                if (secondLock.isHeldByCurrentThread()) {
                    secondLock.unlock();
                }
            }
        }
    }
}
