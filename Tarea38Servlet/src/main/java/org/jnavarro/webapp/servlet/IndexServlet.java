package org.jnavarro.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy ");
        String fecha = df.format(new Date());
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("     <head>");
        out.println("         <meta charset=\"UTF-8\">");
        out.println("         <title>Tarea 38</title>");
        out.println("     </head>");
        out.println("     <body>");
        out.println("         <h1> TAREA 1: SERVLET Y ENVIO DE PARAMETROS</h1>");
        out.println("         <h2> Hola mi nombre es: " + nombre +" "+apellido+ "</h2>");
        out.println("         <h2> la fecha actual  es: "+ fecha + "</h2>");
        out.println("     </body>");
        out.println("</html>");
    }
}
