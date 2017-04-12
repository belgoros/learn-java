package com.sca.patterns.singleton;

public enum Java6FileLogger {
    INSTANCE;

    public void log(String msg) {
        System.out.println("From enum Singleton (java >= 1.6): " + msg);
    }
}
