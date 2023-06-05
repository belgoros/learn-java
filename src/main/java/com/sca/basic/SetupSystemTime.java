package com.sca.basic;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public class SetupSystemTime {

    public static void main(String[] args) {
        SetupSystemTime runner = new SetupSystemTime();
        Clock clock = runner.setToThePast();

        Instant now = Instant.now(clock);
        System.out.println("current instant in the past: " + now);

        clock = runner.setToThePast(Duration.ofDays(-10));
        now = Instant.now(clock);
        System.out.println("When specified duration, current instant in the past: " + now);

        clock = runner.setToTheFuture();
        now = Instant.now(clock);
        System.out.println("current instant in the future: " + now);

        clock = runner.setToTheFuture(Duration.ofDays(10));
        now = Instant.now(clock);
        System.out.println("when specified duration, current instant in the future: " + now);
    }

    /**
     * Rewind the clock back
     * @return a Clock in the past
     */
    public Clock setToThePast(Duration duration) {
        Clock constantClock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        return Clock.offset(constantClock, duration);
    }

    public Clock setToThePast() {
        return setToThePast(Duration.ofDays(-10));
    }

    /**
     * Go to the future
     * @return Clock in the future
     */
    public Clock setToTheFuture(Duration duration) {
        Clock constantClock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        return Clock.offset(constantClock, duration);
    }

    public Clock setToTheFuture() {
        return setToTheFuture(Duration.ofDays(10));
    }
}
