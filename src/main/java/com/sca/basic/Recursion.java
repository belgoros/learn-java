package com.sca.basic;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(powerOf10(3));
    }

    /**
     * Suppose we need to calculate the n-th power of 10. Here our input is n.
     * Thinking in a recursive way, we can calculate (n-1)-th power of 10 first, and multiply the result by 10.
     * @param n number of times to multiply by 10
     * @return 10 to the power of n
     */
    private static int powerOf10(int n) {
        if (n == 0) {
            return 1;
        }
        return powerOf10(n - 1) * 10;
    }
}
