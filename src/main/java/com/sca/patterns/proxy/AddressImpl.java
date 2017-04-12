/**
 *
 */
package com.sca.patterns.proxy;

/**
 * @author scambour
 */
public class AddressImpl implements Address {

    public static final String HOME = "home";
    public static final String WORK = "work";
    private static final long serialVersionUID = 1L;
    private String type;
    private String description;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public AddressImpl() {
    }

    public AddressImpl(String description, String street,
                       String city, String state, String zipCode) {
        this.description = description;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public String getAddress() {
        return description + EOL_STRING + street + EOL_STRING + city + COMMA
                + SPACE + state + SPACE + zipCode + EOL_STRING;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;

    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;

    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String getZipCode() {
        return zipCode;
    }

    @Override
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
