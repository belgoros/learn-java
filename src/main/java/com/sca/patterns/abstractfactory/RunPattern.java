package com.sca.patterns.abstractfactory;


public class RunPattern {

    /**
     * @param args
     */
    public static void main(String[] args) {
        AddressFactory usAddressFactory = new USAddressFactory();
        Address usAddress = usAddressFactory.createAddress();
        PhoneNumber usPhone = usAddressFactory.createPhoneNumber();

        usAddress.setStreet("142 Lois Lane");
        usAddress.setCity("Metropolis");
        usAddress.setRegion("WY");
        usAddress.setPostalCode("54321");
        usPhone.setPhoneNumber("7039214722");

        System.out.println("U.S. address:");
        System.out.println(usAddress.getFullAddress());
        System.out.println("U.S. phone number:");
        System.out.println(usPhone.getPhoneNumber());
        System.out.println();
        System.out.println();

        System.out.println("Creating French Address and Phone Number:");
        AddressFactory frenchAddressFactory = new FrenchAddressFactory();
        Address frenchAddress = frenchAddressFactory.createAddress();
        PhoneNumber frenchPhone = frenchAddressFactory.createPhoneNumber();

        frenchAddress.setStreet("21 Rue Victor Hugo");
        frenchAddress.setCity("Courbevoie");
        frenchAddress.setPostalCode("40792");
        frenchPhone.setPhoneNumber("011324290");

        System.out.println("French address:");
        System.out.println(frenchAddress.getFullAddress());
        System.out.println("French phone number:");
        System.out.println(frenchPhone.getPhoneNumber());

        System.out.println("Creating Belgian Address and Phone Number:");
        AddressFactory BelgiumAddressFactory = new BelgiumAddressFactory();
        Address BelgiumAddress = BelgiumAddressFactory.createAddress();
        PhoneNumber BelgiumPhone = BelgiumAddressFactory.createPhoneNumber();

        BelgiumAddress.setStreet("Rue Centrum, 5");
        BelgiumAddress.setCity("Charleroi");
        BelgiumAddress.setPostalCode("6000");
        BelgiumPhone.setPhoneNumber("012345678");

        System.out.println("Belgian address:");
        System.out.println(BelgiumAddress.getFullAddress());
        System.out.println("Belgian phone number:");
        System.out.println(BelgiumPhone.getPhoneNumber());

    }
}
