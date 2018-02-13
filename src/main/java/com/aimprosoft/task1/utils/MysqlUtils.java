package com.aimprosoft.task1.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MysqlUtils {


    private static Connection connection = null;



    public static Connection getConnection() {
        if (connection == null) {
            connect();
        }
        return connection;

    }

    private static void connect() {

        try {
            Properties prop = new Properties();
            InputStream inputStream = MysqlUtils.class.getClassLoader().getResourceAsStream("db.properties");
            prop.load(inputStream);
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            }
            catch (IOException | ClassNotFoundException | SQLException e) {
               e.printStackTrace();
            }


    }

    public static void disconnect() {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();

          
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






}
