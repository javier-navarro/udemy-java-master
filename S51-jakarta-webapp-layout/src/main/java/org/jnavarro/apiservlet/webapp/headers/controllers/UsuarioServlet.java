package org.jnavarro.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jnavarro.apiservlet.webapp.headers.models.Usuario;
import org.jnavarro.apiservlet.webapp.headers.service.LoginService;
import org.jnavarro.apiservlet.webapp.headers.service.LoginServiceSessionImpl;
import org.jnavarro.apiservlet.webapp.headers.service.UsuarioService;
import org.jnavarro.apiservlet.webapp.headers.service.UsuarioServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = (Connection)req.getAttribute("conn") ;
        UsuarioService  service = new UsuarioServiceImpl(connection);
        List<Usuario> usuarios = service.listar();

        LoginService login = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = login.getUsername(req);

        req.setAttribute("usuarios", usuarios);
        req.setAttribute("username", usernameOptional);
        req.setAttribute("title", req.getAttribute("title")+ ": Listado de usuarios");
        getServletContext().getRequestDispatcher("/listarUsuarios.jsp").forward(req,resp);
    }
}
