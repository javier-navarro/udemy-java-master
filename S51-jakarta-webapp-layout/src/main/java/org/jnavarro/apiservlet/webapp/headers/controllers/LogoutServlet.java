package org.jnavarro.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.jnavarro.apiservlet.webapp.headers.service.LoginService;
import org.jnavarro.apiservlet.webapp.headers.service.LoginServiceCookieImpl;
import org.jnavarro.apiservlet.webapp.headers.service.LoginServiceSessionImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService loginService = new LoginServiceSessionImpl();
        Optional<String> username = loginService.getUsername(req);

        if (username.isPresent()) {
            HttpSession session = req.getSession();
            //session.removeAttribute("username");
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath()+ "/login.html");
    }
}
