package com.sca.yamlbeans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.sca.basic.Developer;

/**
 * Created by serguei_cambour on 10/12/2015.
 */
public class ReadFromYaml {

    public static void main(final String[] args) throws FileNotFoundException, YamlException {
        ClassLoader classLoader = ReadFromYaml.class.getClassLoader();
        File file = new File(classLoader.getResource("developer.yml").getFile());

        YamlReader reader = new YamlReader(new FileReader(file));
        Developer developer = reader.read(Developer.class);

        System.out.println(developer);
    }
}
