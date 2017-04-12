package com.sca.basic.variables;

public class PlayingStrings {

    public static void main(String[] args) {
        String s1 = "hi";
        String s2 = new String("hi");
        String s3 = "hi";
        if (s1 == s2) {
            System.out.println("s1 and s2 equal");
        } else {
            System.out.println("s1 and s2 not equal");
        }
        if (s1 == s3) {
            System.out.println("s1 and s3 equal");
        } else {
            System.out.println("s1 and s3 not equal");
        }

        String myText = "I'd like to change";
        System.out.println("text before change: " + myText);
        changeMe(myText);
        System.out.println("text after change: " + myText);
    }

    private static void changeMe(String text) {
        text = "No, you can't";
    }
}
