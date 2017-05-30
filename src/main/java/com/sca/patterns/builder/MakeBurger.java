package com.sca.patterns.builder;

public class MakeBurger {
    public static void main(String[] args) {
        Burger burger = (new BurgerBuilder(14))
                .addPepperoni()
                .addLettuce()
                .addTomato()
                .build();
    }
}
