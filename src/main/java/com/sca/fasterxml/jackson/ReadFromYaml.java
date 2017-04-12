package com.sca.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by serguei_cambour on 10/12/2015.
 */
public class ReadFromYaml {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = ReadFromYaml.class.getClassLoader();
        File file = new File(classLoader.getResource("developer.yml").getFile());
        //ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        /*try {
            Developer developer = mapper.readValue(file, Developer.class);
            System.out.println(developer.getFirstName());

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        YAMLFactory factory = new YAMLFactory();
        JsonParser parser = factory.createParser(file); // don't be fooled by method name...
        while (parser.nextToken() != null) {
            System.out.println(parser.getText());
        }
    }
}
