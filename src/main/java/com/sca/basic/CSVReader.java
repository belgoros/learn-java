package com.sca.basic;

import java.io.*;

public class CSVReader {

    private final static String SEPARATOR = ",";

    /**
     * @param args
     */
    public static void main(String[] args) {
        String fileName = "batchsample.csv";
        CSVReader reader = new CSVReader();
        File csvFile = reader.getCSVFile(fileName);
        System.out.println(" file size in bytes: " + csvFile.length());
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                // use comma as separator
                String[] values = line.split(SEPARATOR);

                System.out.println("Row Values: ");
                for (String value : values) {
                    System.out.print(value);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private File getCSVFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        return file;
    }
}
