package org.jnavarro.apiservlet.webapp.tarea47.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static String url = "jdbc:mysql://localhost:3307/java_curso?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "7979";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}

