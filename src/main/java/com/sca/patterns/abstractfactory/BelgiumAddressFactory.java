package com.sca.patterns.abstractfactory;

public class BelgiumAddressFactory implements AddressFactory {

    @Override
    public Address createAddress() {
        // TODO Auto-generated method stub
        return new BelgiumAdress();
    }

    @Override
    public PhoneNumber createPhoneNumber() {
        // TODO Auto-generated method stub
        return new BelgiumPhoneNumber();
    }

}
