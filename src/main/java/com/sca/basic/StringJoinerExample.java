package com.sca.basic;

import java.util.StringJoiner;

public class StringJoinerExample {
    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner("/");
        joiner.add("v2").add("example.com").add("clients");
        System.out.println(joiner.toString());
    }
}
