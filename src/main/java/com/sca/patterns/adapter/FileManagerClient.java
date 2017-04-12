package com.sca.patterns.adapter;

public class FileManagerClient {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String dummyData = "dynamite";
        FileManager fileManager = new FileManagerImpl();
        System.out.println("Using filemanager: " + fileManager.getClass().toString());
        fileManager.open("dummyfile.dat");
        fileManager.write(0, dummyData.length(), dummyData.getBytes());
        String test = fileManager.read(0, dummyData.length(), dummyData.getBytes());
        System.out.println("Data written and read: " + test);
        fileManager.close();
    }
}
