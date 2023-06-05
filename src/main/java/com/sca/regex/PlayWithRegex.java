package com.sca.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayWithRegex {

    public static void main(String[] args) {
        checkLineFeedCarriageReturnAndOthers();

    }

    private static void checkLineFeedCarriageReturnAndOthers() {
        String input = "Vente par Mme SAUCE et Mme SCHMIT à Mr DETRY Daniel (D:2220917|374)" + "\n\r\f\tVos certificats PEB et électriques.";
        String regexp = "^$|^[\\u000A\\u000D\\u000C\\u0009\\u0020-\\u007E\\u00A0-\\u02AF\\u20A0-\\u20BF]+$";
        Pattern pattern = Pattern.compile(regexp);
        Matcher m = pattern.matcher(input);
        boolean isMatched = m.matches();
        if (isMatched) {
            System.out.println("The specified patter matches");
        }
        else {
            System.out.println("Oups, no matches");
        }

    }

    private static void checkNrn(String value) {
        Pattern NRN_PATTERN = Pattern.compile("\\d{11}");
        boolean matches = NRN_PATTERN.matcher(value).matches();
        System.out.println("Match result: " + matches);
    }

    private static void checkNewton(String input, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        boolean isMatched = m.matches();
        if (isMatched) {
            System.out.println("The specified patter matches");
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
            System.out.println("The specified patter matches");
            System.out.println("matched group 1 -> " + m.group(1));
            System.out.println("matched group 2 -> " + m.group(2));
            System.out.println("matched group 3 -> " + m.group(3));
        } else {
            System.out.println("Oups, no matches");
        }
    }
}
