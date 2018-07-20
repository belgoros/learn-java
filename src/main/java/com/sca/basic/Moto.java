package com.sca.basic;

public class Moto extends Vehicle {

    @Override
    int getWheels() {
        return 2;

    }

    @Override
    void info() {
        System.out.println("This is a Moto");

    }

}
