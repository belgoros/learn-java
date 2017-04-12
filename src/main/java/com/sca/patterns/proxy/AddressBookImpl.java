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
public class AddressBookImpl implements AddressBook {
    private File file;
    private List<Address> addresses = new ArrayList<Address>();

    public AddressBookImpl(File file) {
        this.file = file;
        open();
    }

    @Override
    public void add(Address address) {
        if (!addresses.contains(address)) {
            addresses.add(address);
        }
    }

    @Override
    public List<Address> getAllAddresses() {
        return addresses;
    }

    /*
     * (non-Javadoc)
     * 
     * @see patterns.proxy.AddressBook#getAddress(java.lang.String)
     */
    @Override
    public Address getAddress(String description) {
        for (Address address : addresses) {
            if (address.getDescription().equalsIgnoreCase(description)) {
                return address;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void open() {
        addresses = (List<Address>) FileLoader.loadData(file);

    }

    @Override
    public void save() {
        FileLoader.storeData(file, addresses);
    }
}
