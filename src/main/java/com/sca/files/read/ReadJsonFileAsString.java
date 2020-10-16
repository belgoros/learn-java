package com.sca.files.read;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class ReadJsonFileAsString {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = ReadJsonFileAsString.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("kafka.json")).getFile());

        Path path = Paths.get(file.getAbsolutePath());
        System.out.println("path: " + path.toString());

        String jsonData = new String(Files.readAllBytes(Paths.get(path.toString())));

        System.out.println("++++++++ JSON ++++++++++");
        System.out.println(jsonData);

    }
}
