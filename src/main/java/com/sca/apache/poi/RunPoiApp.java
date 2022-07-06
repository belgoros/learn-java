package com.sca.apache.poi;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class RunPoiApp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String fileName = "myfile.xls";
        createExcelFile(fileName);
        updateExcelFile(fileName);
        readExcelFile(fileName);
    }

    private static void createExcelFile(String fileName) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sample sheet");

        SortedMap<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{"Emp No.", "Name", "Salary"});
        data.put("2", new Object[]{1, "John", 1500000d});
        data.put("3", new Object[]{2, "Sam", 800000d});
        data.put("4", new Object[]{3, "Dean", 700000d});

        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                } else if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Double) {
                    cell.setCellValue((Double) obj);
                }
            }
        }

        try {
            FileOutputStream out = new FileOutputStream(new File(fileName));
            workbook.write(out);
            workbook.close();
            out.close();
            System.out.println("Excel written successfully..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateExcelFile(String fileName) {
        try {
            FileInputStream file = new FileInputStream(new File(fileName));

            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Cell cell = null;

            // Update the value of cell
            cell = sheet.getRow(1).getCell(2);
            cell.setCellValue(cell.getNumericCellValue() * 2);
            cell = sheet.getRow(2).getCell(2);
            cell.setCellValue(cell.getNumericCellValue() * 2);
            cell = sheet.getRow(3).getCell(2);
            cell.setCellValue(cell.getNumericCellValue() * 2);

            file.close();

            FileOutputStream outFile = new FileOutputStream(new File(fileName));
            workbook.write(outFile);
            workbook.close();
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readExcelFile(String fileName) {
        try {

            FileInputStream file = new FileInputStream(new File(fileName));

            // Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            // Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()) {
                        case NUMERIC:
                            System.out.print((int) cell.getNumericCellValue()
                                    + "\t\t");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
            FileOutputStream out = new FileOutputStream(new File(fileName));
            workbook.write(out);
            workbook.close();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
