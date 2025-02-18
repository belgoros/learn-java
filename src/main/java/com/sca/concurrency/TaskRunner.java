package com.sca.concurrency;

/**
 * The TaskRunner class maintains two simple variables.
 * Its main method creates another thread that spins on the ready variable as long as it’s false.
 * When the variable becomes true, the thread prints the number variable.
 *
 * Many may expect this program to print 42 after a short delay; however, the delay may be much
 * longer. It may even hang forever or print zero.
 *
 * We can use volatile to tackle the issues with Cache Coherence.
 *
 * To ensure that updates to variables propagate predictably to other threads,
 * we should apply the `volatile` modifier to those variables.
 * A shared variable that includes the volatile modifier guarantees that all threads see a consistent value
 * for the shared variable.
 * Any update to a volatile field updates the shared value of the field immediately. In other words,
 * a different thread cannot get an inconsistent value of the shared variable after its value is updated
 */
public class TaskRunner {

    private volatile static int number;
    private volatile static boolean ready;

    private static class Reader extends Thread {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }

            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new Reader().start();
        number = 42;
        ready = true;
    }
}
