package org.jnavarro.apiservlet.webapp.headers.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.jnavarro.apiservlet.webapp.headers.service.ServiceJdbcException;
import org.jnavarro.apiservlet.webapp.headers.util.ConexionBaseDatos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConexionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try(Connection connection = ConexionBaseDatos.getConnection()){
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            try {
                servletRequest.setAttribute("conn", connection);
                filterChain.doFilter(servletRequest,servletResponse);
                connection.commit();
            }catch(SQLException | ServiceJdbcException e){
                connection.rollback();
                ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                e.printStackTrace();
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
