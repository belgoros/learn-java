package com.sca.files.read;

import com.sca.files.Folders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ZFTC0418 on 09/03/2015.
 */
public class ReadWithFileReader {

    public static void main(String[] args) {
        String line = "";
        String filename = Folders.ENTITIES_XML;
        // wrap a BufferedReader around FileReader
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
