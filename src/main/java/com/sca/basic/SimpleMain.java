package com.sca.basic;

public class SimpleMain {

    public static void main(String[] args) {
        System.out.println("Hello from SimpleMain class");
        System.out.println("There are "  + args.length + " arguments passed in");
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
