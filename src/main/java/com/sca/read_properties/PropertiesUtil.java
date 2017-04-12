/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sca.read_properties;

import java.io.*;
import java.util.Properties;

/**
 * @author DRIVER
 */
public class PropertiesUtil {

    private static Properties properties = null;

    private PropertiesUtil() {
    }

    public static Properties loadProperties() {
        if (properties == null) {
            properties = new Properties();
        }
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(inputStream);
        } catch (IOException ex) {
            System.err.println("Error when reading a file ++++++++++++++++");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }

    public static Properties initProperties() {
        if (properties == null) {
            properties = new Properties();
        }
        InputStream inputStream =
                PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return properties;
    }

    public static void storeProperty(String key, String value, String comment) {
        if (properties == null) {
            properties = new Properties();
        }
        OutputStream output = null;
        try {
            output = new FileOutputStream("src/main/resources/config.properties");
            // set the properties value
            properties.setProperty(key, value);
            properties.store(output, comment);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
