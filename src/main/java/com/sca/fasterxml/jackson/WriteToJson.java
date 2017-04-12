package com.sca.fasterxml.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sca.basic.Developer;
import com.sca.files.Folders;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by ZFTC0418 on 19/03/2015.
 */
public class WriteToJson {

    public static void main(String[] args) throws IOException {
        Developer developer = initDeveloper();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(initOutputFile(), developer);
        System.out.println("--Done--");
    }

    private static Developer initDeveloper() {
        Developer developer = new Developer();
        developer.setFirstName("John");
        developer.setLastName("Pollac");
        developer.setBirthDate(new Date());
        developer.setEmail("john.pollac@example.com");

        return developer;
    }

    private static File initOutputFile() {
        StringBuilder builder = new StringBuilder();
        builder.append(Folders.FILES_FOLDER);
        builder.append(File.separator);
        builder.append("developers_");
        builder.append(System.nanoTime());
        builder.append(".json");

        File outputFile = new File(builder.toString());

        return outputFile;
    }
}
