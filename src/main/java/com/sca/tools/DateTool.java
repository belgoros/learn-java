package com.sca.tools;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTool {

    public static void main(String[] args) {
        Date today = createCurrentDate();
        Date futureDate = createFutureDate();

        System.out.println("Today is: " + today);
        System.out.println("The future date is: " + futureDate);
        calculateDateDifferenceInDays(today, futureDate);
    }

    public static Date createCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        Date today = new Date(calendar.getTimeInMillis());
        return today;
    }

    public static Date createFutureDate() {
        Calendar futureCalendar = Calendar.getInstance();
        futureCalendar.set(Calendar.MONTH, 3);
        futureCalendar.set(Calendar.DATE, 30);
        Date futureDate = new Date(futureCalendar.getTimeInMillis());
        return futureDate;
    }

    private static void calculateDateDifferenceInDays(Date startDate, Date targetDate) {
        long diffMillis = targetDate.getTime() - startDate.getTime();
        System.out.println("Difference in millis: " + diffMillis);
        long days = TimeUnit.MILLISECONDS.toDays(diffMillis);
        System.out.println("Difference between dates: " + days + " day(s)");
    }
}
