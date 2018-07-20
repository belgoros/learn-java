package com.sca.patterns.visitor;

/**
 * general visitable  interface
 */
public interface Visitable {
    void accept(Visitor visitor);
}
