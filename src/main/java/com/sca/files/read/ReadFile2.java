/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sca.files.read;

import com.sca.properties.PropertiesUtil;

import java.io.*;


public class ReadFile2 {

    public static void main(String[] args) {
        String property_key = "text_file_name";
        String property_value_value = PropertiesUtil.loadProperties()
                .getProperty(property_key);

        File file = new File("src/" + property_value_value);
        StringBuffer contents = new StringBuffer();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            // repeat until all lines is read
            while ((text = reader.readLine()) != null) {
                contents.append(text).append(
                        System.getProperty("line.separator"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // show file contents here
        System.out.println(contents.toString());
    }
}
