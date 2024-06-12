package com.sca.tools;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTool {

    protected static String ZONE_ID_BRUSSELS = "Europe/Brussels";

    public static void main(String[] args) {
        Date today = createCurrentDate();
        Date futureDate = createFutureDate();

        System.out.println("Today is: " + today);
        System.out.println("The future date is: " + futureDate);
        calculateDateDifferenceInDays(today, futureDate);
    }

    public static OffsetDateTime localDateTimeWithZoneToOffsetDateTime(LocalDateTime localDateTime, ZoneId zoneId) {
        return localDateTime.atZone(zoneId).toOffsetDateTime();
    }

    public static OffsetDateTime localDateTimeBrusselsZoneToOffsetDateTime(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.of(ZONE_ID_BRUSSELS);
        return localDateTimeWithZoneToOffsetDateTime(localDateTime, zoneId);
    }

    public static Date createCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        return new Date(calendar.getTimeInMillis());
    }

    public static Date createFutureDate() {
        Calendar futureCalendar = Calendar.getInstance();
        futureCalendar.set(Calendar.MONTH, 3);
        futureCalendar.set(Calendar.DATE, 30);
        return new Date(futureCalendar.getTimeInMillis());
    }

    private static void calculateDateDifferenceInDays(Date startDate, Date targetDate) {
        long diffMillis = targetDate.getTime() - startDate.getTime();
        System.out.println("Difference in millis: " + diffMillis);
        long days = TimeUnit.MILLISECONDS.toDays(diffMillis);
        System.out.println("Difference between dates: " + days + " day(s)");
    }
}
