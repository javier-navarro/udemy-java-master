package org.jnavarro.bdd.jdbc.repositorio;

import org.jnavarro.bdd.jdbc.modelo.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositorioImpl implements Repositorio<Categoria> {

    private Connection connection;

    public CategoriaRepositorioImpl() {
    }

    public CategoriaRepositorioImpl(Connection connection) {
        this.connection = connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM CATEGORIAS")) {
             while (resultSet.next()){
                 Categoria categoria = crearCategoria(resultSet);
                 categorias.add(categoria);
                 //opcion 2
                 // categorias.add(crearCategoria(resulSet))
             }
        }
        return categorias;
    }

    @Override
    public Categoria porId(Long id) throws SQLException {
        Categoria categoria = null;
        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CATEGORIAS WHERE ID=?")){
            preparedStatement.setLong(1,id);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    categoria = crearCategoria(resultSet);
                }
            }
        }
        return categoria;
    }

    @Override
    public Categoria guardar(Categoria categoria) throws SQLException {
        String sql = null;
        if(categoria.getId() != null && categoria.getId()> 0){
            sql = "UPDATE CATEGORIAS SET NOMBRE=? WHERE ID=?";
        }else{
            sql = "insert into  CATEGORIAS(nombre) values(?)";
        }
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1,categoria.getNombre());
            if(categoria.getId() != null && categoria.getId()> 0){
                preparedStatement.setLong(2,categoria.getId());
            }
            preparedStatement.executeUpdate();

            if(categoria.getId() ==null){
                try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                    if(resultSet.next()){
                        categoria.setId(resultSet.getLong(1));
                    }
                }
            }
        }
        return categoria;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try(PreparedStatement preparedStatement = connection.prepareStatement("delete from categorias where id=?")){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        }

    }

    private static Categoria crearCategoria(ResultSet resultSet) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(resultSet.getLong("id"));
        categoria.setNombre(resultSet.getString("nombre"));
        return categoria;
    }
}
