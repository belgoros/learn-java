package com.sca.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sca.basic.Developer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by serguei_cambour on 09/12/2015.
 */
public class WriteManyWithFactory {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();

        JsonGenerator jGenerator = factory.createGenerator(new File("generated_developers.json"), JsonEncoding.UTF8);
        jGenerator.writeStartObject(); // starting a curly brace {
        jGenerator.writeFieldName("developers");
        List<Developer> developers = new ArrayList<>();

        for(int i = 1; i<=5; i++) {
            developers.add(createDeveloper(i));
        }
        jGenerator.writeObject(developers);
        jGenerator.writeEndObject();
        jGenerator.close();
    }

    private static Developer createDeveloper(int index) throws IOException {
        Developer developer = new Developer();
        developer.setBirthDate(new Date());
        developer.setFirstName("Jean-" + index);
        developer.setLastName("Dupont-" + index);
        developer.setEmail("jd-" + index + "@mail.com");

        return developer;
    }
}
