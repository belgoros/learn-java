/**
 *
 */
package com.sca.patterns.proxy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author scambour
 */
public class AddressBookProxy implements AddressBook {

    private File file;
    private List<Address> localAddresses = new ArrayList<Address>();
    private AddressBookImpl addressBook;

    public AddressBookProxy(String fileName) {
        file = new File(fileName);
    }

    @Override
    public void add(Address address) {
        if (addressBook != null) {
            addressBook.add(address);
        } else if (!localAddresses.contains(address)) {
            localAddresses.add(address);
        }
    }

    @Override
    public List<Address> getAllAddresses() {
        if (addressBook == null) {
            open();
        }
        return addressBook.getAllAddresses();
    }

    @Override
    public Address getAddress(String description) {
        for (Address address : localAddresses) {
            if (address.getDescription().equals(description)) {
                return address;
            }
        }
        if (addressBook == null) {
            open();
        }

        return addressBook.getAddress(description);
    }

    @Override
    public void open() {
        addressBook = new AddressBookImpl(file);
        for (Address address : localAddresses) {
            addressBook.add(address);
        }
    }

    @Override
    public void save() {
        if (addressBook != null) {
            addressBook.save();
        } else if (!localAddresses.isEmpty()) {
            open();
            addressBook.save();
        }
    }
}
