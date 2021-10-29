package com.sca.patterns.abstractfactory;


public interface AddressFactory {
    Address createAddress();

    PhoneNumber createPhoneNumber();
}
