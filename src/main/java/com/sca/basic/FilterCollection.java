package com.sca.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by z28scamb on 04/08/2016.
 */
public class FilterCollection {

    public static void main(final String[] args) {

        FilterCollection runner = new FilterCollection();
        List<Developer> developers = runner.createList();

        // selecting the developers according to the method condition
        Stream<Developer> filterStream = developers.stream().filter(developer -> respondToNameCriteria(developer.getLastName(), "Du"));

        // Collect the found developers into the list
        List<Developer> filteredList = filterStream.collect(Collectors.toList());

        System.out.println("Selected developers:" + "\n");
        for (Developer developer : filteredList) {
            System.out.println(developer.getLastName());
        }

        // selecting the developers according to the method condition
        Developer first = developers.stream()
                .filter(developer -> developer.getLastName().equalsIgnoreCase("Cambier")).findFirst().orElse(null);
        System.out.println("First found Developer: " + first.getLastName());

        if(runner.foundSameFirstName(developers) || runner.foundSameLastName(developers)) {
            System.out.println("Found duplicates");
        }
    }

    private boolean foundSameLastName(final List <Developer>developers) {
        Set<String> unicums = new HashSet<>();
        return developers.removeIf(developer -> !unicums.add(developer.getLastName()));
    }

    private boolean foundSameFirstName(final List <Developer>developers) {
        Set<String> unicums = new HashSet<>();
        return developers.removeIf(developer -> !unicums.add(developer.getFirstName()));
    }

    private List<Developer> createList() {
        List<Developer> list = new ArrayList<>();
        list.add(createDeveloper("Jean", "Dupont"));
        list.add(createDeveloper("Martin", "Durand"));
        list.add(createDeveloper("Olivier", "Cambier"));
        list.add(createDeveloper("Jerome", "Cambier"));
        list.add(createDeveloper("Hélène", "Dubois"));
        list.add(createDeveloper("Jacques", "Heureux"));

        return list;
    }

    private Developer createDeveloper(final String firstName, final String lastName) {
        Developer developer = new Developer();
        developer.setLastName(lastName);

        return developer;
    }

    private static boolean respondToNameCriteria(final String lastName, final String criteria) {
        return lastName.startsWith(criteria);
    }
}
