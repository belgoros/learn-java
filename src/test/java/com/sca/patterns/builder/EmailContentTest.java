package com.sca.patterns.builder;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmailContentTest {

    @Test
    public void shouldHavePriority() {
        EmailContent.EmailContentBuilder emailContentBuilder = new EmailContent.EmailContentBuilder();
        EmailContent emailContent = emailContentBuilder.priority("high").build();
        String expectedPriority = emailContent.getPriority();
        assertEquals(expectedPriority, "high");
    }
}
