package com.sca.basic;

/**
 * Created by z28scamb on 07/06/2016.
 * also called LoD
 * <p/>
 * More formally, the Law of Demeter for functions requires that a method m of an object O may only
 * invoke the methods of the following kinds of objects:[2]
 * <p/>
 * 1. O itself
 * 2. m's parameters
 * 3. Any objects created/instantiated within m
 * 4. O's direct component objects
 * 5. A global variable, accessible by O, in the scope of m
 */
public class LawOfDemeterDemo {

    /**
     * This method shows two violations of "Law of Demeter" or "Principle of least knowledge".
     */
    public void process(Order order) {
        // as per rule 1, this method invocation is fine, because o is a argument of process() method
        Message msg = order.getMessage();

        // this method call is a violation, as we are using msg, which we got from Order.
        // We should ask order to normalize message, e.g. "o.normalizeMessage();"
        msg.normalize();

        // this is also a violation, instead of using a temporary variable it uses a method chain.
        order.getMessage().normalize();

        // this is OK, a constructor call, not a method call.
        Instrument instrument = new Instrument();

        // as per rule 4, this method call is OK, because instance of Instrument is created locally.
        instrument.populate();
    }
}
