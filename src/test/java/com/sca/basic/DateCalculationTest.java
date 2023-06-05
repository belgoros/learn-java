package com.sca.basic;

import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    public void testInstantToLocalDateTime() {
        LocalDateTime localDateTime = DateCalculation.instantToLocalDateTime(buildInstant("2021-05-17T13:11:07.00Z"));
        assertThat(localDateTime.getYear()).isEqualTo(2021);
        assertThat(localDateTime.getMonthValue()).isEqualTo(5);
        Assertions.assertThat(localDateTime.getDayOfMonth()).isEqualTo(17);
    }

    /**
     *         String beforeTime = "2021-05-17T23:11:07.00Z";
     *         String afterTime = "2022-05-17T23:11:07.048Z";
     * @param timeAsString
     * @return
     */
    private Instant buildInstant(String timeAsString) {
        Instant parsedInstant = Instant.parse(timeAsString.trim());
        /*DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern, Locale.US);
        LocalDateTime localDateTime = LocalDateTime.parse(stringDate, dateTimeFormatter);
        ZoneId zoneId = ZoneId.of("America/Chicago");
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        Instant instant = zonedDateTime.toInstant();*/

        return parsedInstant;
    }
}
