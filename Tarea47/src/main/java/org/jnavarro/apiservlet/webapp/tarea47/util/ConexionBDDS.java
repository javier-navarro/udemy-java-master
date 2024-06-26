package org.jnavarro.apiservlet.webapp.tarea47.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexionBDDS {

    public static Connection getConnection() throws SQLException {
        Context initContext = null;
        DataSource ds = null;
        try {
            initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            ds = (DataSource)envContext.lookup("jdbc/mysqlDB");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        return ds.getConnection();
    }

}
