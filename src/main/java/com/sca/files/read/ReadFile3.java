/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sca.files.read;

import com.sca.files.Folders;

import java.io.*;

public class ReadFile3 {

    /**
     * The entry point to the class and application.
     *
     * @param args Array of String arguments.
     */
    public static void main(String[] args) {
        doReadWriteTextFile();
    }

    private static void doReadWriteTextFile() {

        try {

            // input/output file names
            String inputFileName = Folders.INVOICE_XML;
            String outputFileName = Folders.FILES_FOLDER + File.separator + "ReadWriteTextFile.txt";

            // Create FileReader Object
            FileReader inputFileReader = new FileReader(inputFileName);
            FileWriter outputFileReader = new FileWriter(outputFileName);

            // Create Buffered/PrintWriter Objects
            BufferedReader inputStream = new BufferedReader(inputFileReader);
            PrintWriter outputStream = new PrintWriter(outputFileReader);

            // Keep in mind that all of the above statements can be combined
            // into the following:

            // BufferedReader inputStream = new BufferedReader(new FileReader("README_InputFile.txt"));
            // PrintWriter outputStream = new PrintWriter(new FileWriter("ReadWriteTextFile.out"));

            outputStream.println("+---------- Testing output to a file ----------+");
            outputStream.println();

            String inLine = null;

            while ((inLine = inputStream.readLine()) != null) {
                outputStream.println(inLine);
            }

            outputStream.println();
            outputStream.println("+---------- Testing output to a file ----------+");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {

            System.out.println("IOException:");
            e.printStackTrace();
        }
    }
}
