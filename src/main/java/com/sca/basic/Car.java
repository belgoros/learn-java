package com.sca.basic;

public class Car extends Vehicle {

    private int wheels;

    @Override
    int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    void info() {
        System.out.println("This is a Car !");
    }

    @Override
    public String toString() {
        return "Car{" +
                "wheels=" + wheels +
                '}';
    }
}
