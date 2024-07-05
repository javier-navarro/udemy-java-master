package org.jnavarro.apiservlet.webapp.headers.repositories;

import jakarta.inject.Inject;
import org.jnavarro.apiservlet.webapp.headers.configs.MysqlConn;
import org.jnavarro.apiservlet.webapp.headers.configs.Repositorio;
import org.jnavarro.apiservlet.webapp.headers.models.entities.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repositorio
@RepositoryJdbc
public class CategoriaRepositoryImpl implements Repository<Categoria> {

    private Connection conn;

    @Inject
    public CategoriaRepositoryImpl(@MysqlConn Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try(Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * from categorias")){
            while(rs.next()){
                Categoria categoria = getCategoria(rs);
                categorias.add(categoria);
            }
        }
        return categorias;
    }

    @Override
    public Categoria porId(Long id) throws SQLException {
        Categoria categoria = null;
        try(PreparedStatement preparedStatement = conn.prepareStatement("select ¨from categorias as c where c.id=?")){
            preparedStatement.setLong(1,id);
            try (ResultSet rs = preparedStatement.executeQuery()){
                if(rs.next()){
                    categoria = getCategoria(rs);
                }
            }
        }

        return categoria;
    }

    @Override
    public void guardar(Categoria categoria) throws SQLException {

    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }

    private static Categoria getCategoria(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setNombre(rs.getString("nombre"));
        categoria.setId(rs.getLong("id"));
        return categoria;
    }
}
