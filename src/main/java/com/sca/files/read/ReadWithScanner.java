/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sca.files.read;

import com.sca.properties.PropertiesUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * @author DRIVER
 */
public class ReadWithScanner {
    // PRIVATE //
    private final File fFile;

    /**
     * @param aFileName full name of an existing, readable file.
     */
    public ReadWithScanner(String aFileName) {
        fFile = new File(aFileName);
    }

    public static void main(String[] args) throws FileNotFoundException {

        String fileToRead = PropertiesUtil.loadProperties().getProperty(
                "text_file_name");
        ReadWithScanner parser = new ReadWithScanner("src" + File.separator
                + fileToRead);
        parser.processLineByLine();
        log("Done.");
    }

    private static void log(Object aObject) {
        System.out.println(String.valueOf(aObject));
    }

    /**
     * Template method that calls {@link #processLine(String)}.
     */
    public final void processLineByLine() throws FileNotFoundException {
        Scanner scanner = new Scanner(fFile);
        try {
            // first use a Scanner to get each line
            while (scanner.hasNextLine()) {
                processLine(scanner.nextLine());
            }
        } finally {
            // ensure the underlying stream is always closed
            scanner.close();
        }
    }

    /**
     * Overridable method for processing lines in different ways.
     * <p/>
     * <p/>
     * This simple default implementation expects simple name-value pairs,
     * separated by an '=' sign. Examples of valid input :
     * <tt>height = 167cm</tt> <tt>mass =  65kg</tt>
     * <tt>disposition =  "grumpy"</tt>
     * <tt>this is the name = this is the value</tt>
     */
    protected void processLine(String aLine) {
        // use a second Scanner to parse the content of each line
        Scanner scanner = new Scanner(aLine);
        scanner.useDelimiter("\n");
        if (scanner.hasNext()) {
            String line = scanner.next();
            log("Line is : " + line);
        } else {
            log("Empty or invalid line. Unable to process.");
        }
        // (no need for finally here, since String is source)
        scanner.close();
    }

    @SuppressWarnings("unused")
    private String quote(String aText) {
        String QUOTE = "'";
        return QUOTE + aText + QUOTE;
    }
}
