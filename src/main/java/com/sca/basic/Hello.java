package com.sca.basic;

import lombok.Getter;

@Getter
public class Hello {

    private final String greeting;

    public Hello(String greeting) {
        this.greeting = greeting;
    }

    public String printGreeting() {
        return sayHi(getGreeting());
    }

    public String printWelcome() {
        return sayWelcome(getGreeting());
    }

    private String sayHi(String prefix) {
        return String.join(", ", prefix, "World");
    }

    private static String sayWelcome(String prefix) {
        return String.join(", ", prefix, "World");
    }
}
