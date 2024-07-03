package com.sca.files.read;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class ReadJSONAsResource {
    public static final String JSON_FILE = "data.json";

    public static void main(String[] args) {
        ReadJSONAsResource main = new ReadJSONAsResource();
        String jsonString = main.readResourceFile();
        System.out.println(jsonString);

    }

    public String readResourceFile(String fileName) {
        var inputStream = getClass().getResourceAsStream("/" + fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("File not found! " + fileName);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            return null;
        }
    }

    public String readResourceFile() {
        return readResourceFile(JSON_FILE);
    }
}
