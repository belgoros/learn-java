package com.sca.patterns.decorator;

public class WithMilk extends CoffeeDecorator {
    public WithMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5; //overriding methods of abstract class
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", Milk";//overriding methods of abstract class
    }
}
