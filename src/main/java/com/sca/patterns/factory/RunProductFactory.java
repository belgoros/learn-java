package com.sca.patterns.factory;

public class RunProductFactory {
    /*
     * Usage example The Connection object in the java package sql is a factory.
     * Depending on the database driver you use you get the database vendors
     * implementation of the Statement interface. In the following example we
     * actually get an OracleStatement object from the package
     * oracle.jdbc.driver when calling createStatement.
     * 
     * 
     * static Connection con; 
     * static Statement stmt; 
     * public static void main(String[] args) { 
     * 	try {
     * 	  Class.forName("oracle.jdbc.driver.OracleDriver"); 
     * 	  con  = DriverManager.getConnection("myServer", "user", "password"); 
     *    stmt = con.createStatement(); 
     *  } catch(Exception e) {} 
     * }
     */

    public static void main(String[] args) {
        ProductFactory pf = new ProductFactory();
        Product prod;
        prod = pf.createProduct("A");
        prod.writeName("John Doe");
        prod = pf.createProduct("B");
        prod.writeName("John Doe");
    }
}
