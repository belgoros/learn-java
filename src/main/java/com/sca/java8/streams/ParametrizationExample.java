package com.sca.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.sca.basic.Apple;

public class ParametrizationExample {
    public static void main(String[] args) {
        List<Apple> greenApples = Arrays.asList(
                new Apple("green", 80),
                new Apple("green", 120));

        List <Apple> filteredApples = filterApples(greenApples, new AppleGreenColorPredicate());
        for (Apple filteredApple : filteredApples) {
            System.out.println(filteredApple);
        }

        List<Apple> readApples = Arrays.asList(
                new Apple("red", 80),
                new Apple("red", 120));
        filteredApples = filterApples(readApples, (Apple apple) -> "red".equals(apple.getColor()));
        for (Apple filteredApple : filteredApples) {
            System.out.println(filteredApple);
        }

        List <Apple> lst  = Arrays.asList(new Apple("yellow", 200));
        List <Apple> yellowApples = filter(lst, (Apple a) -> a.getColor().equals("yellow"));
        for (Apple apple : yellowApples) {
            System.out.println("yellow apple: " + apple);
        }

        List<Integer> numbers = Arrays.asList(10,20,45,87);
        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);
        for (Integer evenNumber : evenNumbers) {
            System.out.println("number: " + evenNumber);
        }
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * Use generics types to filter the inventory list
     * @param inventory element list to filter
     * @param predicate predicate
     * @param <T> element type
     * @return filtered elements list
     */
    public static <T>List<T> filter(List<T> inventory, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T element : inventory) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
