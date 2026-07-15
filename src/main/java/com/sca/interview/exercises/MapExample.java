package com.sca.interview.exercises;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<Object,Object> map = new HashMap<>();
        map.put(new Object(), new Object());
        map.put(new Object(), new Object());

        System.out.println(new Object().hashCode() == new Object().hashCode());
        System.out.println(map.size());
        System.out.println(map.get(new Object()));

//------------2d phase ------------
        //TreeMap<Object,Object> treeMap = new TreeMap<>();
        //treeMap.putAll(map);
        //System.out.printf("TreeMap size: %d%n", treeMap.size());
    }
}
