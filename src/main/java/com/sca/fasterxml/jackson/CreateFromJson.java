package com.sca.fasterxml.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sca.basic.Developer;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;


public class CreateFromJson {

    public static void main(String[] args) throws IOException, URISyntaxException {
        CreateFromJson runner = new CreateFromJson();
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = runner.getClass().getClassLoader();
        File file = new File(classLoader.getResource("developers.json").getFile());
        Developer developer = mapper.readValue(file, Developer.class);
        System.out.println(developer);
    }
}
