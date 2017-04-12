package com.sca.basic;

/**
 * Created by ZFTC0418 on 02/04/2015.
 */
public class Logarithms {
    public static void main(String[] args) {
        System.out.println("Nbr" + "\t"
                + "log10" + "\t\t\t\t"
                + "log (ln)" + "\t\t\t\t\t"
                + "lg");
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + "\t" +
                    Math.log10(i) + "\t" +
                    Math.log(i) + "\t" +
                    lg(i));
        }
    }

    public static double lg(double x) {
        return Math.log(x) / Math.log(2.0);
    }
}
