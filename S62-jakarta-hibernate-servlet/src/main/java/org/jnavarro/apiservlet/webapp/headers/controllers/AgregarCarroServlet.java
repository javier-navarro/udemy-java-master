package org.jnavarro.apiservlet.webapp.headers.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jnavarro.apiservlet.webapp.headers.configs.ProductoServicePrincipal;
import org.jnavarro.apiservlet.webapp.headers.models.Carro;
import org.jnavarro.apiservlet.webapp.headers.models.ItemCarro;
import org.jnavarro.apiservlet.webapp.headers.models.entities.Producto;
import org.jnavarro.apiservlet.webapp.headers.service.ProductoService;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/carro/agregar")
public class AgregarCarroServlet extends HttpServlet {

    @Inject
    @ProductoServicePrincipal
    ProductoService service;
    @Inject
    private Carro carro;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Optional<Producto> producto = service.porId(id);
        if (producto.isPresent()) {
            ItemCarro item = new ItemCarro(1, producto.get());
            carro.addItemCarro(item);
        }
        resp.sendRedirect(req.getContextPath()+ "/carro/ver");
    }
}
