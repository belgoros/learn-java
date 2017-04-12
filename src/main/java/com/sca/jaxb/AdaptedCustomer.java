package com.sca.jaxb;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by ZFTC0418 on 27/02/2015.
 */
public class AdaptedCustomer {
    private String name;
    private Address address;

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
