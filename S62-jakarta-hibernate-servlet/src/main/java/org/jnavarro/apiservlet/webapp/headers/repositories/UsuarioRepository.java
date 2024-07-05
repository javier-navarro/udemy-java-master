package org.jnavarro.apiservlet.webapp.headers.repositories;

import org.jnavarro.apiservlet.webapp.headers.models.entities.Usuario;


public interface UsuarioRepository extends Repository<Usuario>{
    Usuario porUsername(String username) throws Exception;
}
