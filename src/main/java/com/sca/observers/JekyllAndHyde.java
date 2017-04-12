package com.sca.observers;

import java.util.Observable;

public class JekyllAndHyde extends Observable {
    private String name = "Dr. Jekyll";

    public void drinkPotion() {
        name = "Mr.Hyde";
        setChanged();
        notifyObservers();
    }

    public String getName() {
        return name;
    }

}
