package com.sca.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CountMaxCharactersSequence {
    public static void main(String[] args) {
        String input = "a simple string with aaabbbccccdddd";
        char[] chars = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            Integer charCount = map.putIfAbsent(aChar, 1);
            if (charCount != null) {
                charCount++;
                map.put(aChar, charCount);
            }
        }
        Optional<Integer> max = map.values().stream().max((v1, v2) -> v1.compareTo(v2));
        System.out.println("Max sequence: " + max.get());
    }
}
