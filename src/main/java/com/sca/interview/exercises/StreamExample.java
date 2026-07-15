package com.sca.interview.exercises;

import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> list = List.of(-1, 4, 5);
        System.out.println(sum(list));
    }

    private static int sum(List<Integer> list) {
        // сумма квадратов нечётных чисел
        return list.stream()
                .filter(i -> i % 2 != 0)
                .map(i -> i * i)
                .mapToInt(Integer::intValue).sum();
    }
}
