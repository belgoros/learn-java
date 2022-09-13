package com.sca.basic;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.math3.random.RandomDataGenerator;

public class RandomValuesGenerator {
    public static void main(String[] args) {
        randomDigitsOfGivenRange();
        randomStringOfGivenLength();
    }

    private static void randomDigitsOfGivenRange() {
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        long generated = randomDataGenerator.nextLong(11_000_000_000L, 11_999_999_999L);
        System.out.println(generated);
    }

    private static void randomStringOfGivenLength() {
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        System.out.println(generatedString);
    }
}
