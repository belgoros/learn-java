/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sca.person;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Serguei CAMBOUR
 */
public class Person {

    private int age;
    private String firstName;
    private String lastName;
    private Properties properties;

    public Person(int age, String firstName, String lastName) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
        initProperties();
        System.out.println("Got system properties: " + properties.getProperty("host"));
    }

    private void initProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/app.properties"));
        } catch (IOException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String answerTheAgeQuestion() {
        return "I am " + age + " years old";
    }

    public String full_name() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
