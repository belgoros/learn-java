package com.sca.patterns.visitor;


/**
 * Created by Serguei on 01/08/2017.
 */
public interface Visitor {
    void visit(Book book);

    //visit other concrete items
    void visit(CD cd);

    void visit(DVD dvd);
}
