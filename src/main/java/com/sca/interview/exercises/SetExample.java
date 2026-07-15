package com.sca.interview.exercises;

import java.util.Collection;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Collection<Integer> collection = Set.of(1, 2, 4, 6);
        collection.add(4); //will raise an error!
        System.out.println(collection.size());
    }
}
