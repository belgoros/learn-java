package com.sca.patterns.visitor;

/**
 * The following example shows a simple implementation of the pattern in Java.
 * The example we'll use here is a postage system. Our set of elements will be the items in our shopping cart.
 * Postage will be determined using the type and the weight of each item, and of course depending on where the
 * item is being shipped to.
 */
public class PostageVisitor implements Visitor {
    private double totalPostageForCart;

    //collect data about the book
    @Override
    public void visit(Book book) {
        //assume we have a calculation here related to weight and price
        //free postage for a book over 10
        if (book.getPrice() < 10.0) {
            totalPostageForCart += book.getWeight() * 2;
        }
    }

    //add other visitors here
    @Override
    public void visit(CD cd) {

    }

    @Override
    public void visit(DVD dvd) {

    }

    public double getTotalPostage() {
        return totalPostageForCart;
    }
}
