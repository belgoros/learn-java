package com.sca.java8.streams;

import com.sca.person.Person;

public class PersonFirstNamePredicate implements PersonPredicate{
    @Override
    public boolean isAppliedTo(Person person) {
        return person.getFirstName().startsWith("C");
    }
}
