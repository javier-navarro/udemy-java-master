package org.jnavarro.apiservlet.webapp.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/registro")
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String pais = req.getParameter("pais");
        String[] lenguajes = req.getParameterValues("lenguajes");
        String[] roles = req.getParameterValues("roles");
        String idioma = req.getParameter("idioma");
        boolean habilitar = req.getParameter("habilitar") != null && req.getParameter("habilitar").equals("on");
        String secreto = req.getParameter("secreto");

//        List<String> errores = new ArrayList<>();
        Map<String,String> errores = new HashMap<>();

        if (username == null || username.isBlank()) {
            //errores.add("el usuario es requerido");
            errores.put("username","el usuario es requerido" );
        }

        if (password == null || password.isBlank()) {
            errores.put("password","el password es requerido" );
        }

        if (email == null || email.isBlank() || !email.contains("@")) {
            errores.put("email","el email es requerido, y debe tener formato requerido" );
        }

        if (pais == null || pais.equals("") || pais.equals(" ")) {
            errores.put("pais","el pais es requerido" );
        }

        if (lenguajes == null || lenguajes.length == 0) {
            errores.put("lenguajes","debe seleccionar al menos un tema" );
        }

        if (roles == null || roles.length == 0) {
            errores.put("roles","debe seleccionar al menos un rol" );
        }

        if (idioma == null) {
            errores.put("idioma","debe seleccionar un idioma" );
        }

        if (errores.isEmpty()) {
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("     <head>");
                out.println("         <meta charset=\"UTF-8\">");
                out.println("         <title>Resultados Form</title>");
                out.println("         <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">");
                out.println("         <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>");
                out.println("     </head>");
                out.println("     <body>");
                out.println("         <h1>Resultados Form</h1>");
                out.println("         <ul>");

                out.println("           <li>Username: " + username + "</li>");
                out.println("           <li>Password: " + password + "</li>");
                out.println("           <li>Email: " + email + "</li>");
                out.println("           <li>Pais: " + pais + "</li>");
                out.println("           <li>Lenguajes: <ul>");
                Arrays.asList(lenguajes).forEach(lenguaje -> {
                    out.println("           <li>" + lenguaje + "</li>");
                });
                out.println("           </ul></li> ");
                out.println("           <li>Roles: <ul>");
                Arrays.asList(roles).forEach(rol -> {
                    out.println("           <li>" + rol + "</li>");
                });
                out.println("           </ul></li> ");
                out.println("           <li>Idioma: " + idioma + "</li>");
                out.println("           <li>Habilitar: " + habilitar + "</li>");
                out.println("           <li>Secreto: " + secreto + "</li>");
                out.println("         </ul>");
                out.println("     </body>");
                out.println("</html>");
            }
        } else {
//                errores.forEach(error -> {
//                    out.println("<li>"+ error +"</li>");
//                });
//                out.println("<p><a href=\"/S41-jakarta-webapp-form/index.jsp\">volver</a> ");
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
