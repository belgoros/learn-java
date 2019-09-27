package com.sca.java8.optional;

import java.util.List;
import java.util.Optional;

public class OptionalCar {
    private String mark;


    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void print() {
        System.out.println(getMark());
    }

    public static void main(String[] args) {
        List<OptionalCar> cars = null; //Arrays.asList(buildCar(StringUtils.EMPTY), buildCar("audi"));

        Optional<List<OptionalCar>> optionalList = Optional.ofNullable(cars);

        System.out.println("+++++++ " + optionalList.isPresent());
        Optional<OptionalCar> optionalCar = cars.stream().filter(car -> !car.getMark().isEmpty()).findFirst();
        optionalCar.ifPresent(OptionalCar::print);
    }


    private static OptionalCar buildCar(String mark) {
        OptionalCar car = new OptionalCar();
        car.setMark(mark);
        return car;
    }
}
