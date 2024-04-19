package org.jnavarro.bdd.jdbc.repositorio;

import java.sql.SQLException;
import java.util.List;

public interface ProductoRepositorio<T> {
    List<T> listar() throws SQLException;

    T porId(Long id);

    void guardar(T t);

    void eliminar(Long id);
}
