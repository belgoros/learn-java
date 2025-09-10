package com.sca.basic;

public class StatusHandlerWithEnumsExample {

    public enum Status {
        TO_DO {
            @Override
            public void handle() {
                System.out.println("Handling TO_DO: prepare task.");
            }
        },
        PROCESSING {
            @Override
            public void handle() {
                System.out.println("Handling PROCESSING: executing task.");
            }
        },
        VALIDATION {
            @Override
            public void handle() {
                System.out.println("Handling VALIDATION: checking results.");
            }
        },
        DONE {
            @Override
            public void handle() {
                System.out.println("Handling DONE: closing task.");
            }
        };

        // Each enum constant must implement this
        public abstract void handle();
    }

    // Example usage
    public static void main(String[] args) {
        Status trick = Status.PROCESSING;

        // Instead of if/else or switch
        trick.handle();

    }
}
