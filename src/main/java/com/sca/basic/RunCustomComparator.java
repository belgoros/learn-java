package com.sca.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Serguei on 13/10/2017.
 */
public class RunCustomComparator {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        Car car = new Car();
        car.setWheels(4);
        cars.add(car);

        Car veryLongCar = new Car();
        veryLongCar.setWheels(10);
        cars.add(veryLongCar);

        Car longCar = new Car();
        longCar.setWheels(6);
        cars.add(longCar);

        System.out.println("before:" + cars);

        Collections.sort(cars, new CarWheelsComparator());
        System.out.println("after sorting:" + cars);
    }
}
