package com.sca.java8.streams;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Serguei on 28/11/2016.
 */
public class SimpleFilterStream {

    public static void main(String[] args) {
        sortByAge();
        List<Person> persons = initPersonsList();

        List<Person> result = persons.stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors.<Person>toList());

        result.forEach(System.out::println);

        Person anyPerson = persons.stream()
                .filter(person -> person.getAge() > 20)
                .findAny()
                .orElse(null);

        System.out.println("First found Person older than 20 years old: " + anyPerson);

        Person firstPerson = persons.stream()
                .filter(person -> person.getAge() > 100)
                .findFirst()
                .orElse(null);

        System.out.println(firstPerson);

        List<Integer> personAges = getPersonAges(persons);
        System.out.println("ages: " + personAges.toString());

        List<Person> distinctPersons = persons.stream().filter(distinctByKey(p -> p.getAge())).collect(Collectors.toList());
        System.out.println(distinctPersons);
    }

    private static void sortByAge() {
        new Person(24).addChild(new Child(26)).addChild(new Child(16));
        List<Person> people = Arrays.asList(
                new Person(24).addChild(new Child(16)).addChild(new Child(6)),
                new Person(34).addChild(new Child(18)).addChild(new Child(10)),
                new Person(44).addChild(new Child(10)).addChild(new Child(4)),
                new Person(54).addChild(new Child(14)).addChild(new Child(3)),
                new Person(42).addChild(new Child(2)).addChild(new Child(1))
        );

        //List<Child> children = people.stream().flatMap(person -> person.getChildren().stream()).collect(Collectors.toList());
        System.out.println("before sorting: " + people);

        Collections.sort(
                people.stream().flatMap(person -> person.getChildren().stream()).collect(Collectors.toList()),
                Comparator.comparing(Child::getAge)
        );

        System.out.println("After sorting: " + people);
    }

    private static List<Person> initPersonsList() {
        List<Person> persons = new ArrayList<>();
        for (int i = 10; i < 50; i += 10) {
            persons.add(new Person(i));
        }

        return persons;
    }

    private static List<Integer> getPersonAges(List<Person> persons) {
        List<Integer> ages = persons.stream().map(p -> p.getAge()).collect(Collectors.toList());

        return ages;
    }

    private static class Person {
        List<Child> children = new ArrayList<>();
        int age;

        public Person(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public Person addChild(Child child) {
            this.children.add(child);
            return this;
        }

        public List<Child> getChildren() {
            return children;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "children=" + children +
                    ", age=" + age +
                    '}';
        }
    }

    private static class Child {
        int age;

        public Child(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Child{" +
                    "age=" + age +
                    '}';
        }
    }

    public static <T> Predicate<T> distinctByKey(
            Function<? super T, ?> keyExtractor) {

        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
