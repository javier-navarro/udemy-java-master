package org.jnavarro.apiservlet.webapp.headers.service;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface LoginService {
    Optional<String> getUsername(HttpServletRequest req);
}
