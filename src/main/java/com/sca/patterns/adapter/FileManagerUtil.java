package com.sca.patterns.adapter;

public class FileManagerUtil {

    public boolean openFile(String fileName) {
        System.out.println("Opening file: " + fileName);
        boolean success = true;
        return success;
    }

    public boolean closeFile() {
        System.out.println("Closing file");
        boolean success = true;
        return success;
    }

    public boolean writeToFile(String d, long pos, long amount) {
        System.out.print("Writing " + amount + " chars from string: " + d);
        System.out.println(" to pos: " + pos + " in file");
        boolean success = true;
        return success;
    }

    public String readFromFile(long pos, long amount) {
        System.out.print("Reading " + amount + " chars from pos: " + pos
                + " in file");
        return "dynamite";
    }
}
