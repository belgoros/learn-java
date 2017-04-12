package com.sca.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BatchStructuredLine")//by default the name will be downcased and camel-cased)
@XmlAccessorType(XmlAccessType.FIELD)
public class BatchStructuredLine implements BatchEntity {

    @XmlElement
    private String number;

    @XmlElement
    private String extension;

    @XmlElement
    private String street;

    @XmlElement
    private String locality;

    @XmlElement
    private String postalCode;

    @XmlElement
    private String city;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public void setValuesFromCSV(String[] values) {
        setNumber(values[0]);
        setExtension(values[1]);
        setStreet(values[2]);
        setLocality(values[3]);
        setPostalCode(values[4]);
        setCity(values[5]);
    }

    @Override
    public String toString() {
        return "BatchStructuredLine{" +
                "number='" + number + '\'' +
                ", extension='" + extension + '\'' +
                ", street='" + street + '\'' +
                ", locality='" + locality + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
