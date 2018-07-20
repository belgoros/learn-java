package com.sca.patterns.visitor;

import java.util.List;

/**
 * To drive this visitor, we'll need a way of iterating through our shopping cart
 */
public class ShoppingCart {
    //normal shopping cart stuff
    private List<Visitable> items;

    public double calculatePostage() {
        //create a visitor
        PostageVisitor visitor = new PostageVisitor();
        //iterate through all items
        for (Visitable item : items) {
            item.accept(visitor);
        }
        double postage = visitor.getTotalPostage();
        return postage;
    }
}
