package com.sca.patterns.proxy;

import java.util.List;

public interface AddressBook {
    public void add(Address address);

    public List<Address> getAllAddresses();

    public Address getAddress(String description);

    public void open();

    public void save();

}
