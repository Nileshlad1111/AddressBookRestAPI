package com.bridgelabz.addressbook.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/address_book_service?useSSL=false";
    private final static String DB_USERNAME = "root";
    private final static String DB_PASSWORD = "gopi";

    public static Connection getConnection() {
        Connection con = null;
        try {
            // load the Driver Class
            Class.forName("com.mysql.jdbc.Driver");

            // create the connection now
            con = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("DB Connection created successfully");
        return con;
    }

}
