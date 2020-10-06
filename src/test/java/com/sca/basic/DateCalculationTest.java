package com.sca.basic;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.*;

import static org.junit.Assert.assertEquals;

public class DateCalculationTest {

    static DateCalculation dateCalculation;

    @BeforeClass
    public static void setUp() {
        LocalDate dateUnderTest = LocalDate.of(2020, 10, 2);
        dateCalculation = new DateCalculation(dateUnderTest);
    }

    @Test
    public void getDate() {
        LocalDate date = LocalDate.of(2020, 10, 2);
        assertEquals(date, dateCalculation.getDate());
    }

    @Test
    public void getMonthFromDate() {
        int monthFromDate = dateCalculation.getMonthFromDate();
        assertEquals(10, monthFromDate);
    }

    @Test
    public void getYearFromDate() {
        assertEquals(2020, dateCalculation.getYearFromDate());
    }

    @Test
    public void getDayFromDate() {
        assertEquals(2, dateCalculation.getDayFromDate());
    }

    @Test
    public void getDayOfWeek() {
        assertEquals(DayOfWeek.FRIDAY.name(), dateCalculation.getDayOfWeek());
    }

    @Test
    public void getCurrentWeekFirstDay() {
        LocalDate monday = LocalDate.of(2020, 9, 28);
        assertEquals(monday, dateCalculation.getCurrentWeekFirstDay());
    }
}
