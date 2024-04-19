package org.jnavarro.bdd.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static String url = "jdbc:mysql://localhost:3307/tarea37?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "7979";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if (connection ==null){
            connection = DriverManager.getConnection(url,username,password);
        }
        return connection;
    }
}