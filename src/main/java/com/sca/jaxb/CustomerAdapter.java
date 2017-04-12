package com.sca.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by ZFTC0418 on 27/02/2015.
 */
public class CustomerAdapter extends XmlAdapter<AdaptedCustomer, Customer> {

    @Override
    public Customer unmarshal(final AdaptedCustomer adaptedCustomer) throws Exception {
        return new Customer(adaptedCustomer.getName(), adaptedCustomer.getAddress());
    }

    @Override
    public AdaptedCustomer marshal(final Customer customer) throws Exception {
        AdaptedCustomer adaptedCustomer = new AdaptedCustomer();
        adaptedCustomer.setName(customer.getName());
        adaptedCustomer.setAddress(customer.getAddress());

        return adaptedCustomer;
    }
}
