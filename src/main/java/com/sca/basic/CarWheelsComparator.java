package com.sca.basic;

import org.apache.commons.collections.comparators.NullComparator;

import java.util.Comparator;

/**
 * Created by Serguei on 13/10/2017.
 */
public class CarWheelsComparator implements Comparator<Car> {

    private final static NullComparator NULL_COMPARATOR = new NullComparator(false);


    @Override
    public int compare(Car o1, Car o2) {
        return NULL_COMPARATOR.compare(o1.getWheels(), o2.getWheels());
    }
}
