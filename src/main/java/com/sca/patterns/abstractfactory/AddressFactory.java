package com.sca.patterns.abstractfactory;


public interface AddressFactory {
    public Address createAddress();

    public PhoneNumber createPhoneNumber();
}
