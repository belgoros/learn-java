package com.regex;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CheckNumberTest {


    private static final String NUMBER_REGEX = "\\A[-+]?\\d+(\\.\\d+)?";
    private static final String ZERO_REGEX = "\\A[-+]?0+([.,]0+)?";

    @Test
    public void shouldTakeLastFiveDigits() {
        assertTrue(matchStoreNumber("30243"));
        assertFalse(matchStoreNumber("0"));
    }

    private static int runTest(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        return matches;
    }

    @Test
    public void givenText_whenMatchesWithDotMetach_thenCorrect() {
        int matches = runTest(".", "foo");

        Assert.assertTrue(matches > 0);
    }

    @Test
    public void givenRepeatedText_whenMatchesOnceWithDotMetach_thenCorrect() {
        int matches= runTest("foo.", "foofoo");

        assertEquals(matches, 1);
    }

    @Test
    public void shouldMatchANumber() {
        String number = "0.00";
        Assert.assertTrue(isNumeric(number));
    }

    @Test
    public void shouldMatchAZero() {
        String number = "0,00";
        Assert.assertTrue(isZero(number));
    }

    private boolean isNumeric(String str) {
        return str.matches(NUMBER_REGEX);  //match a number with optional '-' and decimal.
    }

    private boolean isZero(String str) {
        return str.matches(ZERO_REGEX);
    }

    private static boolean matchStoreNumber(String input) {
        String regex = "(\\d{5}$)";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(input);
        return matcher.matches();
    }
}
