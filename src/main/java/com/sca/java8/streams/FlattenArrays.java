package com.sca.java8.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlattenArrays {

    public static void main(String[] args) {
        Object[] array = {1, 2, new Object[]{3, 4, new Object[]{5}, 6, 7}, 8, 9, 10};
        System.out.println("original: " + Arrays.deepToString(array));

        Object[] flat = flatten(array).toArray();
        System.out.println("flat:     " + Arrays.toString(flat));

    }

    private static Stream<Object> flatten(Object[] array) {
        return Arrays.stream(array)
                .flatMap(o -> o instanceof Object[] ? flatten((Object[]) o) : Stream.of(o));
    }
}
