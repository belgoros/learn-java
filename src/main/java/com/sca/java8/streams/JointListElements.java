package com.sca.java8.streams;

import com.sca.basic.Developer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JointListElements {

    public static void main(String[] args) {
        List<Developer> developers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Developer developer = new Developer();
            developer.setLastName("Hacher-" + i);
            developers.add(developer);
        }

        final List<String> lastNames = developers.stream().map(Developer::getLastName).collect(Collectors.toList());
        System.out.println(lastNames);

        final String joined = String.join(", ", lastNames);
        System.out.println(joined);

    }
}
