package com.sca.files.write;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by serguei_cambour on 14/12/2015.
 */
public class CreateFile {
    public static void main(String[] args) {
        simpleCreate("simpe_file.txt");
        createFromPath("src/main/resources/foo.log");
        createFromSystemPath("foo.log");
    }

    private static void simpleCreate(String fileName) {
        File file = new File(fileName);
        try {
            boolean created = file.createNewFile();
            if(created) {
                System.out.println("File created at " + file.getAbsolutePath());
            }
            else {
                System.out.println("File not created!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFromSystemPath(String fileName) {
        //The following example creates /users/joe/logs/foo.log assuming
        // your home directory is /users/joe,
        // or C:\Users\joe\logs\foo.log if you are on Windows.
        Path newFile = Paths.get(System.getProperty("user.home"), "logs", fileName);

        try {
            Files.deleteIfExists(newFile);
            newFile = Files.createFile(newFile);
        } catch (IOException e) {
            System.err.println("Error creating file");
        }
        System.out.println("Creating from Path => file created:" + Files.exists(newFile));
    }

    private static void createFromPath(String fileName) {
        Path newFile = Paths.get(fileName);
        try {
            Files.deleteIfExists(newFile);
            newFile = Files.createFile(newFile);
        } catch (IOException e) {
            System.err.println("Error creating file");
        }
        System.out.println("Creating from Path => file created:" + Files.exists(newFile));
    }
}
