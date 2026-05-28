package com.sca.concurrency;

public class DeadlockSimulatorDemo {
    private static final int ITERATIONS = 1_000;
    private static final boolean RUN_WRONG_SCENARIO = false; // true = может зависнуть при дедлоке

    public static void main(String[] args) throws InterruptedException {
        if (RUN_WRONG_SCENARIO) {
            Logger.log("=== Running WRONG scenario (can deadlock) ===");
            runWrongScenario();
        }

        Logger.log("=== Running ORDERED scenario ===");
        runOrderedScenario();

        Logger.log("=== Running TRY_LOCK scenario ===");
        runTryLockScenario();
    }

    private static void runWrongScenario() {
        LockableResource rA = new LockableResource(1, "A");
        LockableResource rB = new LockableResource(2, "B");
        LockableResourceProcessor processor = new WrongLockableResourceProcessor();

        for (int i = 1; i <= ITERATIONS; i++) {
            Logger.log("[wrong][iter=%d] starting", i);
            runPair(processor, rA, rB);
            Logger.log("[wrong][iter=%d] finished (if you see this line, no deadlock happened yet)", i);
        }
    }

    private static void runOrderedScenario() {
        LockableResource rA = new LockableResource(1, "A");
        LockableResource rB = new LockableResource(2, "B");
        LockableResourceProcessor processor = new OrderedLockableResourceProcessor();

        for (int i = 1; i <= ITERATIONS; i++) {
            Logger.log("[ordered][iter=%d] starting", i);
            runPair(processor, rA, rB);
        }
        Logger.log("[ordered] completed all iterations without deadlock");
    }

    private static void runTryLockScenario() {
        LockableResource rA = new LockableResource(1, "A");
        LockableResource rB = new LockableResource(2, "B");
        LockableResourceProcessor processor = new TryLockLockableResourceProcessor();

        for (int i = 1; i <= ITERATIONS; i++) {
            Logger.log("[tryLock][iter=%d] starting", i);
            runPair(processor, rA, rB);
        }
        Logger.log("[tryLock] completed all iterations without deadlock");
    }

    private static void runPair(
            LockableResourceProcessor processor,
            LockableResource r1,
            LockableResource r2
    ) {
        Thread t1 = new Thread(() -> {
            processor.processResources(r1, r2);
        }, "processor-1");

        Thread t2 = new Thread(() -> {
            processor.processResources(r2, r1);
        }, "processor-2");

        t1.start();
        t2.start();

        ThreadJoinUtils.safeJoin(t1, t2);
    }
}
