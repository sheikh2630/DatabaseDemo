/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasedemo;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcDemo {

    public static final String userName = "cphba83";
    public static final String pw = "cphba83";
    public static final String dbms = "oracle";
    static final String driverDerby = "org.apache.derby.jdbc.EmbeddedDriver";
    static final String driverOracle = "oracle.jdbc.driver.OracleDriver";
    static final String connectionOracle = "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat";
    static final String connectionDerby = "jdbc:derby://localhost:1527/myLocalDerbyDatabase";

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", userName);
        connectionProps.put("password", pw);
        if (JdbcDemo.dbms.equals("oracle")) {
            conn = DriverManager.getConnection(connectionOracle, connectionProps);
        } else if (JdbcDemo.dbms.equals("derby")) {
            conn = DriverManager.getConnection(connectionDerby, connectionProps);
        }
        System.out.println("Connected to database");
        return conn;
    }

    public void personQuery() throws SQLException {
        try (Statement stmt = getConnection().createStatement()) {
            stmt.executeQuery("SELECT * FROM PERSON");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                System.out.println("Id:" + rs.getInt(1) + ", " + rs.getString("FIRST_NAME") + ", "
                        + rs.getString("LAST_NAME") + ", " + rs.getInt("PHONE_NUMBER"));
            }
        }
    }

    public static void main(String[] args) {
        JdbcDemo test = new JdbcDemo();
        try {
            test.personQuery();
        } catch (SQLException ex) {
            Logger.getLogger(JdbcDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
