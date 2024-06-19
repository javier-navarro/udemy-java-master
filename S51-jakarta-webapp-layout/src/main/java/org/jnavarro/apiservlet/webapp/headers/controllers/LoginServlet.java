package org.jnavarro.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.jnavarro.apiservlet.webapp.headers.models.Usuario;
import org.jnavarro.apiservlet.webapp.headers.service.*;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Optional;

@WebServlet({"/login","/login.html"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginService login = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = login.getUsername(req);

        if (usernameOptional.isPresent()) {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("     <head>");
                out.println("         <meta charset=\"UTF-8\">");
                out.println("         <title>Bienvenido nuevamente</title>");
                out.println("     </head>");
                out.println("     <body>");
                out.println("         <h1>Hola" +usernameOptional.get()+ " has iniciado sesion con exito!</h1>");
                out.println("     <p> <a href='"+ req.getContextPath() + "/index.jsp'>Volver</a></p>");
                out.println("     <p> <a href='"+ req.getContextPath() + "/logout'>Cerrar sesion</a></p>");
                out.println("     </body>");
                out.println("</html>");
            }
        }else{
            req.setAttribute("title", req.getAttribute("title")+ ": Login");
            getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UsuarioService usuarioService = new UsuarioServiceImpl((Connection) req.getAttribute("conn"));
        Optional<Usuario> usuarioOptional = usuarioService.login(username, password);

        if (usuarioOptional.isPresent()) {

            HttpSession session = req.getSession();
            session.setAttribute("username",username);

            resp.sendRedirect(req.getContextPath() + "/login.html");
        }else{
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "lo sentimos, no tieneslos privilegios.");
        }
    }
}
