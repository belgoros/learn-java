package com.sca.jaxb;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by ZFTC0418 on 27/02/2015.
 */
@XmlRootElement(name = "purchase-order")
public class PurchaseOrder {

    private Customer customer;

    @XmlJavaTypeAdapter(CustomerAdapter.class)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
