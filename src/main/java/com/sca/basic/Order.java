package com.sca.basic;

/**
 * Created by z28scamb on 07/06/2016.
 */
public class Order {

    private Message message;

    public Message getMessage() {
        System.out.println("calling getMessage on Order instance");
        return message;
    }
}
