package com.sca.basic;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class TimeCalculation {
    public static void main(String[] args) {
        runLocalTimeExamples();
        runLocalDateTimeExamples();
        runLocalDateTimeWithChronoUnit();
        runZonedDateTimeExamples();
    }

    private static void runLocalTimeExamples() {
        // create time instances
        LocalTime firstTime = LocalTime.of(11, 30);
        LocalTime secondTime = LocalTime.of(22, 35);

        // calculate difference between times
        Duration duration = Duration.between(firstTime, secondTime);

        // print the difference
        System.out.println("Hours between " + firstTime + " and " + secondTime + ": " + duration.toHours());
        System.out.println("Minutes between " + firstTime + " and " + secondTime + ": " + duration.toMinutes());

        firstTime = LocalTime.of(10, 15, 45);
        secondTime = LocalTime.of(14, 50, 15);

        // calculate difference between times
        long hours = ChronoUnit.HOURS.between(firstTime, secondTime);
        long minutes = ChronoUnit.MINUTES.between(firstTime, secondTime);
        long seconds = ChronoUnit.SECONDS.between(firstTime, secondTime);

        // print the difference
        System.out.println("Hours between " + firstTime + " and " + secondTime + ": " + hours);
        System.out.println("Minutes between " + firstTime + " and " + secondTime + ": " + minutes);
        System.out.println("Seconds between " + firstTime + " and " + secondTime + ": " + seconds);
    }

    private static void runLocalDateTimeExamples() {
        // create datetime instances
        LocalDateTime dateTime1 = LocalDateTime.parse("2018-08-02T15:14");
        LocalDateTime dateTime2 = LocalDateTime.parse("2019-02-14T12:45");

        // calculate difference
        Duration duration = Duration.between(dateTime1, dateTime2);

        // print the difference
        System.out.println("Days between " + dateTime1 + " and " + dateTime2 + ": " + duration.toDays());
        System.out.println("Hours between " + dateTime1 + " and " + dateTime2 + ": " + duration.toHours());
    }

    private static void runLocalDateTimeWithChronoUnit() {
        // create datetime instances
        LocalDateTime pastDateTime = LocalDateTime.of(2019, Month.NOVEMBER, 12, 10, 40);
        LocalDateTime now = LocalDateTime.now();

        // calculate difference
        long months = ChronoUnit.MONTHS.between(pastDateTime, now);
        long days = ChronoUnit.DAYS.between(pastDateTime, now);

        // print days & months
        System.out.println("Months between " + pastDateTime + " and " + now + ": " + months);
        System.out.println("Days between " + pastDateTime + " and " + now + ": " + days);
    }

    private static void runZonedDateTimeExamples() {
        // create datetime instances
        ZonedDateTime dateTime1 = ZonedDateTime.parse("2019-05-15T10:15:30+01:00[Europe/Paris]");
        ZonedDateTime dateTime2 = ZonedDateTime.parse("2020-01-05T12:00:33+05:00[Asia/Karachi]");

        // calculate difference
        Duration duration = Duration.between(dateTime1, dateTime2);

        // print the difference
        System.out.println("Days between " + dateTime1 + " and " + dateTime2 + ": " + duration.toDays());
        System.out.println("Hours between " + dateTime1 + " and " + dateTime2 + ": " + duration.toHours());

        // create datetime instances
        ZonedDateTime pastDateTime = ZonedDateTime.of(2018,2, 18, 10, 30, 0, 0, ZoneId.of("Europe/Paris"));
        ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());

        // calculate difference
        long months = ChronoUnit.MONTHS.between(pastDateTime, now);
        long days = ChronoUnit.DAYS.between(pastDateTime, now);

        // print days & months
        System.out.println("Months between " + pastDateTime + " and " + now + ": " + months);
        System.out.println("Days between " + pastDateTime + " and " + now + ": " + days);
    }
}
