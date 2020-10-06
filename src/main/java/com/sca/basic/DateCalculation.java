package com.sca.basic;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class DateCalculation {

    private final LocalDate date;

    public DateCalculation(LocalDate date) {
        this.date = date;
    }

    public static void main(String[] args) {
        LocalDate from = LocalDate.now();
        LocalDate to = from.plusDays(10);
        System.out.println(" 10 days later: " + to);

        long later = ChronoUnit.DAYS.between(from, to);
        System.out.println(later);    // 10

        LocalDate earlier = from.minusDays(10);
        System.out.println("10 days earlier: " + earlier);

        long diffEarlier = ChronoUnit.DAYS.between(earlier, from);
        System.out.println(diffEarlier); // 10

        LocalDate localDate1 = LocalDate.parse("2019-12-31");
        LocalDate localDate2 = LocalDate.parse("2020-01-08");

        // calculate difference
        long days = Period.between(localDate1, localDate2).getDays();

        // print days
        System.out.println("Days between " + localDate1 + " and " + localDate2 + ": " + days);

        LocalDate pastDate = LocalDate.of(2019, Month.AUGUST, 15);
        LocalDate now = LocalDate.now();

        // calculate difference
        long monthsValue = ChronoUnit.MONTHS.between(pastDate, now);
        long daysValue = ChronoUnit.DAYS.between(pastDate, now);

        // print days & months
        System.out.println("Months between " + pastDate + " and " + now + ": " + monthsValue);
        System.out.println("Days between " + pastDate + " and " + now + ": " + daysValue);

        convertMillisToLocalDate();
    }

    private static void convertMillisToLocalDate() {
        LocalDate now = LocalDate.now();
        System.out.println("now: " + now);

        String millisAsString = convertDateToMillisAsString(now);

        long millis = Long.parseLong(millisAsString);

        LocalDate ld = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("back to date: " + ld);
        System.out.println("2 dates are equal: " + now.isEqual(ld));
    }

    private static String convertDateToMillisAsString(LocalDate _date) {
        long millis = _date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return String.valueOf(millis);
    }

    public LocalDate getDate() {
        return date;
    }

    public int getMonthFromDate() {
        return getDate().getMonthValue();
    }

    public int getYearFromDate() {
        return getDate().getYear();
    }

    public int getDayFromDate() {
        return getDate().getDayOfMonth();
    }

    public String getDayOfWeek() {
        return DayOfWeek.from(getDate()).name();
    }

    public LocalDate getCurrentWeekFirstDay() {
        TemporalAdjuster previousMondayAdjuster = TemporalAdjusters.previous(DayOfWeek.MONDAY);
        return  getDate().with(previousMondayAdjuster);
    }
}
