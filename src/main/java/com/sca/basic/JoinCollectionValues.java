package com.sca.basic;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class JoinCollectionValues {

    public static void main(String[] args) {
        Set<String> developers = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            developers.add("developer#" + i);
        }

        String joined = StringUtils.join(developers, '|');

        System.out.println(joined);
    }
}
