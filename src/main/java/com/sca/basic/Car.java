package com.sca.basic;

public class Car extends Vehicle {

    private int wheels;

    @Override
    void getWheels() {
        System.out.println(wheels);

    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    void info() {
        System.out.println("THis is a Car !");
    }

}
