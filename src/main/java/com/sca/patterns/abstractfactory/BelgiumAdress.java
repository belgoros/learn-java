package com.sca.patterns.abstractfactory;

public class BelgiumAdress extends Address {
    private static final String COUNTRY = "Belgique";

    @Override
    public String getCountry() {
        // TODO Auto-generated method stub
        return COUNTRY;
    }

    @Override
    public String getFullAddress() {
        return getStreet() + EOL_STRING + getPostalCode() + EOL_STRING + getCity() +
                SPACE + COUNTRY + EOL_STRING;
    }
}