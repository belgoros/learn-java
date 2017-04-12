package com.sca.observers;

import java.util.Observable;
import java.util.Observer;

public class Person implements Observer {

    private String name;
    private String says;

    public Person(String name, String says) {
        this.name = name;
        this.says = says;
    }

    @Override
    public void update(Observable thing, Object obj) {
        System.out.println("It’s " +
                ((JekyllAndHyde) thing).getName() + "\n" +
                name + ":" + says);

    }

}
