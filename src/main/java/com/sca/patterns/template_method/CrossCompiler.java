package com.sca.patterns.template_method;

/*
 * The Template Method pattern is used when two or more implementations of a similar algorithm exist. 
 * In the real world templates are used all the time: for architectural plans, and throughout the engineering 
 * domain. A template plan may be defined which is then built on with further variations. 
 * For example, a basic house plan can have many variations such as adding an extensions or using 
 * a different heating system.
 * 
 * The AbstractClass contains the templateMethod(), which should be made final so that it cannot be overridden. 
 * This template method makes use of other operations available in order to run the algorithm, but is decoupled 
 * for the actual implementation of these methods. All operations used by this template method are made abstract, 
 * so their implementation is deferred to subclasses. 
 * 
 * The ConcreteClass implements all the operations required by the templateMethod that were defined as abstract 
 * in the parent class. There can be many different ConcreteClasses. 
 * The Template Method pattern makes use of the Hollywood Principle: Don't call us, we'll call you. 
 * The template method in the parent class controls the overall process, "calling" subclass methods when 
 * necessary. The Hollywood principle avoids low level components depending on high level components, and 
 * instead give these low level classes (ConcreteClass) a way of hooking into the parent class (AbstractClass). 
 */
public abstract class CrossCompiler {
    public final void crossCompile() {
        collectSource();
        compileToTarget();
    }

    // Template methods
    protected abstract void collectSource();

    protected abstract void compileToTarget();
}
