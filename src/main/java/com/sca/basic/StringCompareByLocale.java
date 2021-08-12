package com.sca.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.text.CollationKey;
import java.text.Collator;
import java.util.*;

public class StringCompareByLocale {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Arnaud", "Cambier"),
                new Person(null, "Cambier"),
                new Person("Jérémie", "Cambier"),
                new Person("Cécile", "Cambier"));

        Collections.sort(people, new PersonComparator());
        System.out.println(people);

        Person p1 = new Person(null, "Bérémie");
        Person p2 = new Person(null, "BEREMIE");

        Collator collator = Collator.getInstance(Locale.FRANCE);
        collator.setStrength(Collator.PRIMARY);

        CollationKey[] keys = new CollationKey[2];
        keys[0] = collator.getCollationKey(p1.getLastName());
        keys[1] = collator.getCollationKey(p2.getLastName());

        System.out.println("result: " + keys[0].compareTo(keys[1]));
    }

    @AllArgsConstructor
    @Getter
    @ToString
    private static class Person {
        String firstName;
        String lastName;
    }

    private static class PersonComparator implements Comparator<Person> {

        @Override
        public int compare(Person b1, Person b2) {
            Collator collator = getCollator();
            int compared = compareLastNames(collator, b1, b2);

            if (compared == 0) {
                compared = compareFirstNames(collator, b1, b2);
            }

            return compared;
        }

        private int compareLastNames(Collator collator, Person b1, Person b2) {
            CollationKey[] keys = new CollationKey[2];
            keys[0] = collator.getCollationKey(b1.getLastName());
            keys[1] = collator.getCollationKey(b2.getLastName());

            return keys[0].compareTo(keys[1]);
        }
        private int compareFirstNames(Collator collator, Person b1, Person b2) {
            if (StringUtils.isBlank(b1.getFirstName())) {
                return -1;
            }
            if (StringUtils.isBlank(b2.getFirstName())) {
                return 1;
            }

            CollationKey[] keys = new CollationKey[2];
            keys[0] = collator.getCollationKey(b1.getFirstName());
            keys[1] = collator.getCollationKey(b2.getFirstName());

            return keys[0].compareTo(keys[1]);
        }

        private Collator getCollator() {
            Collator instance = Collator.getInstance(Locale.FRANCE);
            instance.setStrength(Collator.PRIMARY);

            return instance;
        }
    }
}
