package com.example.milkteaproject;
import java.sql.*;

public class DbConnect {
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost/linh_management_milkteashop";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public DbConnect(){
        try {
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Successfully !");
        } catch (SQLException e) {
            System.out.println("error" +e);
        }
    }
}
