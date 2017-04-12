package com.sca.patterns.proxy;

import java.io.File;
import java.util.List;

public class RunPattern {

    public static void main(String[] args) {
        System.out.println("Example for the Proxy pattern");
        if (!new File("data.ser").exists()) {
            DataCreator.serialize("data.ser");
        }
        System.out.println("Creating the AddressBookProxy");
        AddressBookProxy proxy = new AddressBookProxy("data.ser");
        System.out.println("Adding entries to the AddressBookProxy");
        System.out.println("(this operation can be done by the Proxy, without");
        System.out.println(" creating an AddressBooklmpl object)");
        proxy.add(new AddressImpl("Sun Education [CO]", "500 El Dorado Blvd.",
                "Broomfield", "CO", "80020"));
        System.out.println("Addresses created. Retrieving an address");
        System.out
                .println("(since the address is stored by the Proxy, there is");
        System.out
                .println(" still no need to create an AddressBooklmpl object)");
        System.out.println();
        System.out.println(proxy.getAddress("Sun Education [CO]").getAddress());
        System.out.println();
        System.out
                .println("So far, all operations have been handled by the Proxy,");
        System.out
                .println(" without any involvement from the AddressBooklmpl.");
        System.out.println(" Now, a call to the method getAHAddresses will");
        System.out.println(" force instantiation of AddressBooklmpl, and will");
        System.out.println(" retrieve ALL addresses that are stored.");
        System.out.println();
        List<Address> addresses = proxy.getAllAddresses();
        System.out.println("Addresses retrieved. Addresses currently stored:");
        System.out.println(addresses);
    }
}
