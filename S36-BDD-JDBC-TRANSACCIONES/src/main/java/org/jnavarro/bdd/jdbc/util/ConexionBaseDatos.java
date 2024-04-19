package org.jnavarro.bdd.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3307/java_curso?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "7979";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        return connection = DriverManager.getConnection(url,username,password);
    }
}
