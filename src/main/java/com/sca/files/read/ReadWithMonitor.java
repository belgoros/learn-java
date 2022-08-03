package com.sca.files.read;

import com.sca.files.Folders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadWithMonitor {

    public static void main(String[] args) throws IOException {
        String fileName = Folders.ENTITIES_XML;
        File file = new File(fileName);
        long totalBytes = file.length();
        InputStream reader = new FileInputStream(file);

        final int minimalBuffer = (int) (file.length() / 100);
        System.out.println("Minimal buffer: " + minimalBuffer);
        byte[] buffer = new byte[minimalBuffer];
        int byteRead = -1;
        long byteReadSoFar = 0;
        while (-1 != (byteRead = reader.read(buffer))) {
            byteReadSoFar += byteRead;
            System.out.printf("Current progress is: %.2f", byteReadSoFar * 1.0 / totalBytes);
            System.out.println();
        }
        reader.close();
    }
}
