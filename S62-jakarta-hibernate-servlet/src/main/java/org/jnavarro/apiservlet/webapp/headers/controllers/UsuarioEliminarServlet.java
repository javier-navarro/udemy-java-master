package org.jnavarro.apiservlet.webapp.headers.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jnavarro.apiservlet.webapp.headers.models.entities.Usuario;
import org.jnavarro.apiservlet.webapp.headers.service.UsuarioService;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/usuarios/eliminar")
public class UsuarioEliminarServlet extends HttpServlet {

    @Inject
    private UsuarioService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id;
        try{
            id = Long.valueOf(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0L;
        }

        if (id > 0) {
            Optional<Usuario> o = service.porId(id);
            if (o.isPresent()) {
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath()+"/usuarios");
            }else{
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el usuario en BD");
            }
        }
        else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error al enviar el id");
        }

    }
}
