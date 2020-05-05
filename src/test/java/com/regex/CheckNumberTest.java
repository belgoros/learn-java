package com.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class CheckNumberTest {

    @Test
    public void shouldTakeLastFiveDigits() {
        assertTrue(matchStoreNumber("30243"));
        assertFalse(matchStoreNumber("0"));
    }

    private static boolean matchStoreNumber(String input) {
        String regex = "(\\d{5}$)";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(input);
        return matcher.matches();
    }
}
