package com.sca.files;

import org.apache.commons.io.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by ZFTC0418 on 09/03/2015.
 */
public class UseCoomonIO {
    public static void main(String[] args) throws IOException {
        String filename = Folders.ENTITIES_XML;
        File file = new File(filename);
        System.out.println(FilenameUtils.getBaseName(file.getName()));

        // FilenameUtils

        System.out.println("Full path of exampleTxt: " +
                FilenameUtils.getFullPath(filename));

        System.out.println("Full name of exampleTxt: " +
                FilenameUtils.getName(filename));

        System.out.println("Extension of exampleTxt: " +
                FilenameUtils.getExtension(filename));

        System.out.println("Base name of exampleTxt: " +
                FilenameUtils.getBaseName(filename));

        // FileUtils

        // We can create a new File object using FileUtils.getFile(String)
        // and then use this object to get information from the file.
        File exampleFile = FileUtils.getFile(filename);
        LineIterator iter = FileUtils.lineIterator(exampleFile);

        System.out.println("Contents of exampleTxt...");
        while (iter.hasNext()) {
            System.out.println("\t" + iter.next());
        }
        iter.close();

        // We can check if a file exists somewhere inside a certain directory.
        File parent = FileUtils.getFile(Folders.FILES_FOLDER);
        System.out.println("Parent directory contains exampleTxt file: " +
                FileUtils.directoryContains(parent, exampleFile));

        // IOCase

        String str1 = "This is a new String.";
        String str2 = "This is another new String, yes!";

        System.out.println("Ends with string (case sensitive): " +
                IOCase.SENSITIVE.checkEndsWith(str1, "string."));
        System.out.println("Ends with string (case insensitive): " +
                IOCase.INSENSITIVE.checkEndsWith(str1, "string."));

        System.out.println("String equality: " +
                IOCase.SENSITIVE.checkEquals(str1, str2));

        // FileSystemUtils
        System.out.println("Free disk space (in KB): " + FileSystemUtils.freeSpaceKb("C:"));
        System.out.println("Free disk space (in MB): " + FileSystemUtils.freeSpaceKb("C:") / 1024);
    }
}
