package com.sca.java8.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayingWithStream {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("one", "two", "three", "four");
        stream.filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }

    private void useFilter(Stream<String> stream) {
        Stream<String> filteredStream = stream.filter(e -> e.length() > 3);
    }

    private static void usePeek(Stream<String> stream) {
        stream.peek(e -> System.out.println("Filtered value: " + e));
    }
}
