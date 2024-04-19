package org.jnavarro.bdd.jdbc.repositorio;

import org.jnavarro.bdd.jdbc.modelo.Usuario;
import org.jnavarro.bdd.jdbc.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorioImpl implements UsuarioRepositorio<Usuario>{

    private Connection getConnection() throws SQLException {
        return ConexionBD.getInstance();
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "select * from usuarios";

        try(Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){

            while (resultSet.next()){
                Usuario usuario = modelarUsuario(resultSet);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public Usuario buscaUsuarioPorId(Long id) {
        Usuario usuario = new Usuario();
        String sql = "SELECT * FROM USUARIOS WHERE ID=?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                usuario = modelarUsuario(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        System.out.println(usuario);
        String sql;
        if ( usuario.getId() != null && usuario.getId() > 0 ) {
            System.out.println("update");
            sql = "UPDATE USUARIOS SET USERNAME=? , PASSWORD=?, EMAIL=? WHERE ID=?";
        }else {
            System.out.println("insert");
            sql = "INSERT INTO USUARIOS(USERNAME,PASSWORD,EMAIL) VALUES(?,?,?)";
        }
        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1, usuario.getUsername());
            preparedStatement.setString(2, usuario.getPassword());
            preparedStatement.setString(3, usuario.getEmail());

            if (usuario.getId() != null && usuario.getId()>0) {
                preparedStatement.setLong(4, usuario.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarUsuario(Long id) {
        String sql = "delete from usuarios where id=?";
        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Usuario modelarUsuario(ResultSet resultSet) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(resultSet.getLong("id"));
        usuario.setUsername(resultSet.getString("username"));
        usuario.setPassword(resultSet.getString("password"));
        usuario.setEmail(resultSet.getString("email"));
        return usuario;
    }
}
