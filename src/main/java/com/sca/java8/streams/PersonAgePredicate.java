package com.sca.java8.streams;

import com.sca.person.Person;

public class PersonAgePredicate implements PersonPredicate{
    @Override
    public boolean isAppliedTo(Person person) {
        return person.getAge() > 45;
    }
}
