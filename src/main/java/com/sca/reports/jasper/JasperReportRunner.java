package com.sca.reports.jasper;

import net.sf.jasperreports.engine.*;

import java.util.HashMap;
import java.util.Map;

public class JasperReportRunner {

    public static void main(String[] args) throws JRException {
        JasperReport jasperReport = JasperCompileManager.compileReport("A4_example.jrxml");
        // Parameters for report to be generated
        Map<String, Object> parameters = new HashMap<String, Object>();

        // DataSource
        // This is simple example, no database.
        // then using empty datasource.
        JRDataSource dataSource = new JREmptyDataSource();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);


        // Export to PDF.
        JasperExportManager.exportReportToPdfFile(jasperPrint, "jasperTextReport.pdf");

        System.out.println("Done!");
    }
}
