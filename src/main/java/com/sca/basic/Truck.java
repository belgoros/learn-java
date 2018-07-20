package com.sca.basic;

public class Truck extends Vehicle {

    @Override
    int getWheels() {
        return 6;
    }

    @Override
    void info() {
        System.out.println("This is a truck");
    }
}
