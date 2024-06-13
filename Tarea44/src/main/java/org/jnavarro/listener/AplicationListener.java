package org.jnavarro.listener;

import jakarta.servlet.*;

public class AplicationListener implements ServletRequestListener {
    private ServletContext servletContext;

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("Inicializando el request!!");
        sre.getServletRequest().setAttribute("nombreCompleto", "Javier Navarro");
    }
}
