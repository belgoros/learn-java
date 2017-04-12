package com.sca.patterns.abstractfactory;

public class FrenchAddress extends Address {
    private static final String COUNTRY = "FRANCE";

    @Override
    public String getCountry() {
        return COUNTRY;
    }

    /*
     * (non-Javadoc)
     *
     * @see patterns.abstract_factory.Address#getFullAddress()
     */
    @Override
    public String getFullAddress() {
        return getStreet() + EOL_STRING + getPostalCode() + SPACE + getCity()
                + EOL_STRING + COUNTRY + EOL_STRING;
    }

}
