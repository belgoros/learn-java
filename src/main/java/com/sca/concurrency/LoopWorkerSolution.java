package com.sca.concurrency;

import org.slf4j.Logger;

public class LoopWorkerSolution {
    private final static Logger logger = org.slf4j.LoggerFactory.getLogger(LoopWorkerSolution.class);

    public static void main(String[] args) {
        LoopWorker worker = new LoopWorker("Worker-1");
        worker.start();

        ThreadSleepUtil.safeSleepWithoutThrow(2000);

        worker.stopAsync();
    }

    private static class LoopWorker {
        private final Thread internalWorker;
        private int counter = 0;

        public LoopWorker(String name) {
            internalWorker = new Thread(this::doWorkLoop, name);
        }

        public void start() {
            logger.info("Starting worker: {}", internalWorker.getName());
            internalWorker.start();
        }

        public void stopAsync() {
            logger.info("Stopping worker: {}", internalWorker.getName());
            internalWorker.interrupt();
        }

        private void doWorkLoop() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(10);
                    counter++;
                } catch (InterruptedException e) {
                    logger.info("Worker thread {} was interrupted with counter={}.", Thread.currentThread().getName(), counter);
                    Thread.currentThread().interrupt(); // Preserve interrupt status
                }
            }
            logger.info("Worker thread {} has been  with counter={}.", Thread.currentThread().getName(), counter);
        }
    }
}
