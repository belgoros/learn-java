package com.sca.jaxb;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by ZFTC0418 on 27/02/2015.
 */
@XmlJavaTypeAdapter(CustomerAdapter.class)
public class Customer {

    private final String name;
    private final Address address;

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
