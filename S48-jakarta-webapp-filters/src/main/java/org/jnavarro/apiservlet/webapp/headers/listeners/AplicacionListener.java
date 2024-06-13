package org.jnavarro.apiservlet.webapp.headers.listeners;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.jnavarro.apiservlet.webapp.headers.models.Carro;

@WebListener
public class AplicacionListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {

    private ServletContext servletContext;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("Iniciando la app!!");
        servletContext = sce.getServletContext();
        servletContext.setAttribute("mensaje", "algun valor global de la app");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        servletContext.log("Destruyendo la app!!");
    }
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("Inicializando el request!!");
        sre.getServletRequest().setAttribute("mensaje", "guardando algun valor para el request");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        servletContext.log("destruyendo  el request!!");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        servletContext.log("iniciando  la sesion!!");
        Carro carro = new Carro();
        HttpSession session = se.getSession();
        session.setAttribute("carro", carro);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        servletContext.log("destruyendo  la sesion!!");
    }
}
