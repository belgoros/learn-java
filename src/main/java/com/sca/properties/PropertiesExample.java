/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sca.properties;

/**
 * @author DRIVER
 */
public class PropertiesExample {

    public static void main(String[] args) {
        String property_key = "my_favorite_key";
        String property_value = PropertiesUtil.loadProperties().getProperty(property_key);
        System.out.println(property_key + ":" + property_value);
        System.out.println("-----------------Done-----------------");

        System.out.println("Second solution:\n");
        property_value = PropertiesUtil.initProperties().getProperty(property_key);
        System.out.println(property_key + ":" + property_value);
        System.out.println("-----------------Done-----------------");


        System.out.println("Writing to the properties file");
        PropertiesUtil.storeProperty("language", "Java", "Added new property");
        property_value = PropertiesUtil.initProperties().getProperty("language");
        System.out.println("Newly added value: " + property_value);
    }
}
