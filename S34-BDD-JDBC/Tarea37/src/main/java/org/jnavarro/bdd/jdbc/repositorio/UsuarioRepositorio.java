package org.jnavarro.bdd.jdbc.repositorio;

import java.util.List;

public interface UsuarioRepositorio<T> {
    List<T> listarUsuarios();

    T buscaUsuarioPorId(Long id);

    void guardarUsuario(T t);

    void eliminarUsuario(Long id);

}
