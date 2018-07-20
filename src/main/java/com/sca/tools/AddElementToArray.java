package com.sca.tools;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by z28scamb on 06/05/2016.
 */
public class AddElementToArray {

    public static void main(String[] args) {
        String[] array = {"1", "2"};
        array = ArrayUtils.add(array, "3");
        array = ArrayUtils.add(array, "4");

        for (String element : array) {
            System.out.println(element);
        }
    }
}
