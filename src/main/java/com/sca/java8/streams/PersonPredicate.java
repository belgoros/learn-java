package com.sca.java8.streams;

import com.sca.person.Person;

public interface PersonPredicate {
    boolean isAppliedTo(Person person);
}
