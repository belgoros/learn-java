package com.sca.basic;

public enum MyEnums {
    NUMBER("number"), CITY("city");

    private String attributeName;

    private MyEnums(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
}
