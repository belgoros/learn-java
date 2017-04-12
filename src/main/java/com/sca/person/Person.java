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
    private String firstname;
    private String lastname;
    private Properties properties;

    public Person() {
        initProperies();
        System.out.println("Got system properties: " + properties.getProperty("host"));
    }

    private void initProperies() {
        properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/app.properties"));
        } catch (IOException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
        return firstname + " " + lastname;
    }
}
