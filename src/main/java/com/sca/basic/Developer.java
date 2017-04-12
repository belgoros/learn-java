package com.sca.basic;

import java.util.Date;
import java.util.List;

public class Developer {

    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;
    private List<String> phoneNumbers;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("first name: ");
        builder.append(getFirstName());
        builder.append("\n");
        builder.append("last name:");
        builder.append(getLastName());
        builder.append("\n");
        builder.append("email:");
        builder.append(getEmail());
        builder.append("\n");
        builder.append("birthDate:");
        builder.append(getBirthDate());
        if (!phoneNumbers.isEmpty()) {
            builder.append("\nPhone numbers:");
            for (String number : phoneNumbers) {
                builder.append("\n" + number);
            }
        }


        return builder.toString();
    }

    /**
     * @return the phoneNumbers
     */
    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * @param phoneNumbers the phoneNumbers to set
     */
    public void setPhoneNumbers(final List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

}
