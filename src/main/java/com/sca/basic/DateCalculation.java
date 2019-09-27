package com.sca.basic;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateCalculation {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now: " + now);

        final LocalDateTime weeksBefore = now.minus(2, ChronoUnit.WEEKS);
        System.out.println(weeksBefore);
    }
}
