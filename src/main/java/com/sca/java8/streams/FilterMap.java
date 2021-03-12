package com.sca.java8.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Serguei on 22/03/2017.
 */
public class FilterMap {

    public static void main(String[] args) {
        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");

        //Map -> Stream -> Filter -> String
        String result = HOSTING.entrySet().stream()
                .filter(map -> "aws.amazon.com".equals(map.getValue()))
                .map(map -> map.getValue())
                .collect(Collectors.joining());

        System.out.println("With Java 8 : " + result);

        //Map -> Stream -> Filter -> Map
        Map<Integer, String> collect = HOSTING.entrySet().stream()
                .filter(mapEntry -> isTwo(mapEntry.getKey()))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

        System.out.println(collect); //output : {2=heroku.com}
    }

    private static boolean isTwo(int key) {
        boolean result = false;
        if (key == 2) {
            result = true;
        }

        return result;
    }
}
