package com.sca.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayWithRegex {

    public static void main(String[] args) {

        //checkNewton("haproxy[12107]: 127.0.0.1:37265 [07/Dec/2015:13:29:50.850]", "^haproxy\\[(\\d+)\\].*");
        //checkNewton("toto yoyo 2 (12345)", "^(\\w+\\s+)+\\((\\d{5})\\)$");
        checkContentRange();

    }

    private static void checkNewton(String input, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        boolean isMatched = m.matches();
        if (isMatched) {
            System.out.println("The specified pattern " + (isMatched ? "matches" : "does not match"));
            System.out.println("matched group 1 -> " + m.group(1));
            System.out.println("matched group 2 -> " + m.group(2));
        } else {
            System.out.println("Oups, no matches");
        }
    }

    private static void checkContentRange() {
        // range example: 0-49/59
        String regex = "^(\\d+)-(\\d+)/(\\d+)";
        String range = "50-58/59";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(range);

        boolean isMatched = m.matches();
        if (isMatched) {
            System.out.println("The specified pattern " + (isMatched ? "matches" : "does not match"));
            System.out.println("matched group 1 -> " + m.group(1));
            System.out.println("matched group 2 -> " + m.group(2));
            System.out.println("matched group 3 -> " + m.group(3));
        } else {
            System.out.println("Oups, no matches");
        }

    }
}
