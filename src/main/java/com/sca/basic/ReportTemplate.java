package com.sca.basic;

/**
 * Created by Serguei on 18/06/2017.
 */
public class ReportTemplate {

    protected void generateReport() throws Exception {
        retrieve_financial_data();
        format_report();
        send_to_stakeholders();
    }

    private void send_to_stakeholders() {

    }

    private void format_report() throws Exception {
        throw new Exception("Not implemented error");
    }

    private void retrieve_financial_data() {
    }
}
