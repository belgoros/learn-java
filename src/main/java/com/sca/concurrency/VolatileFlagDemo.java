package com.sca.concurrency;

import java.time.LocalTime;

public class VolatileFlagDemo {
    private volatile boolean running;

    public static void main(String[] args) {
        VolatileFlagDemo demo = new VolatileFlagDemo();
        demo.start();
        ThreadSleepUtil.safeSleepWithoutThrow(1_000);
        demo.stop();
    }

    public void start() {
        this.running = true;
        new Thread(() -> {
            while (running) {
                System.out.println("Thread is running..." + LocalTime.now());
            }
            System.out.println("Thread stopped.");
        }).start();
    }

    public void stop() {
        this.running = false;
    }
}
