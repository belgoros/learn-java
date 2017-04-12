package com.sca.calculator;

import java.util.Calendar;

public class RunCalculator {

    public static void main(String[] args) {
        RpnCalculator calc = new RpnCalculator();
        calc.push(10);
        calc.push(5);
        calc.push("+");
        System.out.println("Calculation result: " + calc.value());

        Calendar calendar = Calendar.getInstance();
        //given a date in the past
        calendar.set(2011, 05, 01);
        //create a current date and pass it to the constructor
        DateCalculator calculator = new DateCalculator(Calendar.getInstance().getTime());

        System.out.println("IS your date is in the past? -> " + calculator.isDateInThePast(calendar.getTime()));
    }

}
