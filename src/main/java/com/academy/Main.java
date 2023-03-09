package com.academy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        var prop = new Properties();
        try (InputStream inputStream = new FileInputStream("src/main/resources/db.properties")) {
            prop.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Connection connection= DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.user"),prop.getProperty("db.password"));

        //Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/academy","admin","admin");


    }
}
