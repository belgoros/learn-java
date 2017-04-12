package com.sca.patterns.singleton;

public class RunSingleton {

    public static void main(String[] args) {
        Java6FileLogger java6_singletonFileLogger = Java6FileLogger.INSTANCE;
        java6_singletonFileLogger.log("Log it, please...");

        FileLogger fileLogger = FileLogger.getFileLogger();
        fileLogger.log("Boum !");
    }

}
