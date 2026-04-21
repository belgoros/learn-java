package com.sca.concurrency;

import org.slf4j.Logger;

import java.time.LocalDateTime;
import java.util.List;

public class StartVsRunDemo {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(StartVsRunDemo.class);

    public static void main(String[] args) {
        var inheritedTask = new InheritedTask("inherited-thread");
        var runnable = new RunnableTask("runnable-task");
        var runnableTask = new Thread(runnable);

        var lambdaTask = new Thread(() -> {
            ThreadSleepUtil.safeSleepWithoutThrow(1_000);
        }, "lambda-thread");

        executeWithStart(List.of(inheritedTask, runnableTask, lambdaTask));
        executeWithRun(List.of(inheritedTask, runnableTask, lambdaTask));
    }

    private static void executeWithRun(List<Thread> threads) {
        logger.info("Executing tasks with Run......");
        for (Thread thread : threads) {
            ThreadSleepUtil.safeSleepWithoutThrow(10_000);
            thread.run();
            logWorkingThread(thread.getName(), thread.getState());
        }
    }

    private static void executeWithStart(List<Thread> threads) {
        logger.info("Executing tasks with Start......");
        for (Thread thread : threads) {
            ThreadSleepUtil.safeSleepWithoutThrow(10_000);
            thread.start();
            logWorkingThread(thread.getName(), thread.getState());
        }
    }

    private static class InheritedTask extends Thread {
        public InheritedTask(String s) {
            super(s);
        }

        @Override
        public void run() {
            logWorkingThread(getName(), getState());
        }
    }

    private record RunnableTask(String name) implements Runnable {

        @Override
        public void run() {
            logWorkingThread(name, Thread.currentThread().getState());
        }
    }

    private static void logWorkingThread(String workerName, Thread.State state) {
        logger.info("Working at: {}, Running in thread: {}, in state: {}", LocalDateTime.now(), workerName, state);
    }
}
