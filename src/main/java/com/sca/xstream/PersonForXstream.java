package com.sca.xstream;

public class PersonForXstream {
    private String firstname;
    private String lastname;
    private PhoneForXstream phone;
    private PhoneForXstream fax;

    public PersonForXstream(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the phone
     */
    public PhoneForXstream getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(PhoneForXstream phone) {
        this.phone = phone;
    }

    /**
     * @return the fax
     */
    public PhoneForXstream getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(PhoneForXstream fax) {
        this.fax = fax;
    }

}
