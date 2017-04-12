/**
 *
 */
package com.sca.patterns.abstractfactory;

/**
 * @author MACHINE_DEV3
 */
public class USAddress extends Address {
    private static final String COUNTRY = "UNITED STATES";
    private static final String COMMA = ",";

    @Override
    public String getFullAddress() {
        return getStreet() + EOL_STRING + getCity() + COMMA + SPACE
                + getRegion() + SPACE + getPostalCode() + EOL_STRING + COUNTRY
                + EOL_STRING;
    }

    @Override
    public String getCountry() {
        return COUNTRY;
    }

}
