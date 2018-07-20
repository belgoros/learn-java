package com.sca.basic;

import java.util.Collections;
import java.util.LinkedList;

public class ReverseStrings {

    public static void main(String[] args) {
        String input = "AliveisAwesome";
        reverseByChars(input);
        System.out.println("with builder: => " + reverseWithStringBuilder(input));
        System.out.println("with Collections.reverse: => " + reverseWithCollectionsReverse(input));
        System.out.println("reverse with bytes: => " + reverseWithBytes(input));
    }

    static void reverseByChars(String input) {
        System.out.print("with chars: => ");
        char[] chars = input.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }

    static String reverseWithStringBuilder(String input) {
        StringBuilder builder = new StringBuilder();
        builder.append(input);
        builder = builder.reverse();

        return builder.toString();
    }

    static String reverseWithCollectionsReverse(String input) {
        char[] chars = input.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        for (char character : chars) {
            list.add(character);
        }

        Collections.reverse(list);

        return list.toString();
    }

    static String reverseWithBytes(String input) {
        byte[] bytesArray = input.getBytes();
        byte[] result = new byte[bytesArray.length];

        for (int i = 0; i < bytesArray.length; i++) {
            result[i] = bytesArray[bytesArray.length - i - 1];
        }

        return new String(result);
    }
}
