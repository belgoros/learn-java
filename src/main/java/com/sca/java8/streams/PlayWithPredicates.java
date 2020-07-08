package com.sca.java8.streams;

import com.sca.person.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayWithPredicates {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(25, "John", "Turner"),
                new Person(35, "Jim", "Caily"),
                new Person(45, "Ariane", "Toggly"),
                new Person(55, "Mary", "Leclercq"));

        Predicate<Person> agePredicate = p -> p.getAge() < 20;
        Predicate<Person> firstNamePredicate = p -> p.getFirstName().startsWith("A");
        List<Person> collect = people.stream().filter(agePredicate.or(firstNamePredicate)).collect(Collectors.toList());
        System.out.println("combined with OR people: " + collect);


        Stream<Person> filteredByAge = filterPeople(people, new PersonAgePredicate());
        System.out.println(filteredByAge.collect(Collectors.toList()));

        Predicate<Person> p1 = p -> new PersonAgePredicate().isAppliedTo(p);//> 45
        Predicate<Person> p2 = p -> new PersonFirstNamePredicate().isAppliedTo(p);//starts with C

        List<Person> byAge = people.stream().filter(p1.or(p2)).collect(Collectors.toList());
        System.out.println("by age: " + byAge);
    }

    public static Stream<Person> filterPeople(List<Person> people, PersonPredicate predicate) {
        return people.stream().filter(p -> predicate.isAppliedTo(p));
    }
}
