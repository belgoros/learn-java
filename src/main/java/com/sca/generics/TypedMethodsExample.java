package com.sca.generics;

import com.sca.basic.Developer;
import com.sca.patterns.observer.Person;

public class TypedMethodsExample {

    public static void main(String[] args) {
        Person person = new Person("John", "Hello");
        Person[] persons = {person, new Person("Mark", "Good bye")};
        int count = countOccurrences(persons, person);
        System.out.println("Counted persons: " + count);

        Developer john = new Developer();
        john.setFirstName("John");

        Developer mark = new Developer();
        mark.setFirstName("John");

        Developer[] developers = {john, mark};
        System.out.println("counted developers: " + countOccurrences(developers, mark));

    }

    public static <T> int countOccurrences(T[] list, T itemToCount) {
        int count = 0;
        if (itemToCount == null) {
            for (T listItem : list)
                if (listItem == null)
                    count++;
        } else {
            for (T listItem : list)
                if (itemToCount.equals(listItem))
                    count++;
        }
        return count;
    }
}
