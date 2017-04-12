package com.sca.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by z28scamb on 05/07/2016.
 */
public class GroupingByExample {

    public static void main(String[] args) {
        GroupingByExample sm = new GroupingByExample();
        List<Developer> people = sm.initList(10);


        Map<String, List<Developer>> grouppedByEmail = people
                .stream().collect(
                        Collectors.groupingBy(Developer::getEmail));

        System.out.println(grouppedByEmail);
    }

    private List<Developer> initList(int size) {
        List<Developer> list = new ArrayList<>();
        String fakeLastName = "turner";
        String fakeFirstName = "John";
        list.add(createPerson(fakeFirstName + "-" + 3, fakeLastName + "." + 3 + "@mail.com", "John " + fakeLastName + "#" + 1));

        for (int i = 0; i < size; i++) {
            list.add(createPerson(fakeFirstName + "-" + i,
                    fakeLastName + "." + i + "@mail.com", fakeLastName + "#" + i));
        }

        return list;
    }

    private Developer createPerson(String email, String firstNAme, String lastName) {
        Developer p = new Developer();
        p.setEmail(email);
        p.setLastName(lastName);

        return p;
    }
}
