package com.sca.patterns.proxy;

import java.io.Serializable;

public interface Address extends Serializable {
    public final static String EOL_STRING = System.getProperty("line.separator");
    public final static String SPACE = " ";
    public final static String COMMA = ",";

    public String getAddress();

    public String getType();

    public void setType(String type);

    public String getDescription();

    public void setDescription(String description);

    public String getStreet();

    public void setStreet(String street);

    public String getCity();

    public void setCity(String city);

    public String getState();

    public void setState(String state);

    public String getZipCode();

    public void setZipCode(String zipCode);
}
