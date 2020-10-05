package com.sca.basic;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class DateCalculation {

    private final LocalDate date;

    public DateCalculation(LocalDate date) {
        this.date = date;
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
