package org.jnavarro.apiservlet.webapp.headers.repositories;

import org.jnavarro.apiservlet.webapp.headers.models.Usuario;

import java.sql.SQLException;

public interface UsuarioRepository extends Repository<Usuario>{
    Usuario porUsername(String username) throws SQLException;
}
