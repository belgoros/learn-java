package com.sca.basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class HelloTest {

    @Test
    void shouldPrintGreeting() {
        Hello hello = new Hello("Hello");
        final String result = hello.printGreeting();
        Assertions.assertThat(result).isEqualTo("Hello, World");

        final String welcome = hello.printWelcome();
        Assertions.assertThat(welcome).isEqualTo("Hello, World");
    }

    @Test
    void shouldCallNonStaticMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Hello hello = new Hello("Hello");
        Method methodToCall = Hello.class.getDeclaredMethod("sayHi", String.class);
        methodToCall.setAccessible(true);

        final String result = (String) methodToCall.invoke(hello, "Hello");
        Assertions.assertThat(result).isEqualTo("Hello, World");
    }

    @Test
    void shouldCallStaticMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method methodToCall = Hello.class.getDeclaredMethod("sayWelcome", String.class);
        methodToCall.setAccessible(true);

        final String result = (String) methodToCall.invoke(Hello.class, "Hello");
        Assertions.assertThat(result).isEqualTo("Hello, World");
    }
}
