package org.jnavarro.apiservlet.webapp.headers.repositories;

import org.jnavarro.apiservlet.webapp.headers.models.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryImpl implements UsuarioRepository{

    private Connection conn;

    public UsuarioRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "select * from usuarios";
        try(Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                Usuario usuario = getUsuario(resultSet);
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    @Override
    public Usuario porId(Long id) throws SQLException {
        String sql = "select * from usuarios where id=?";
        Usuario usuario = null;

        try(PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setLong(1,id);
            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    usuario = getUsuario(resultSet);
                }
            }
        }
        return usuario;
    }

    @Override
    public void guardar(Usuario usuario) throws SQLException {
        String sql;
        if (usuario.getId() != null && usuario.getId() >0) {
            sql = "update usuarios set username=?, password=?, email=? where id=?";
        } else {
            sql = "insert into usuarios (username,password,email) values (?,?,?)";
        }

        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1, usuario.getUsername());
            preparedStatement.setString(2, usuario.getPassword());
            preparedStatement.setString(3, usuario.getEmail());

            if(usuario.getId() != null && usuario.getId() > 0){
                preparedStatement.setLong(4, usuario.getId());
            }
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "delete from usuarios where id=?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        }
    }

    private static Usuario getUsuario(ResultSet resultSet) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(resultSet.getLong("id"));
        usuario.setUsername(resultSet.getString("username"));
        usuario.setPassword(resultSet.getString("password"));
        usuario.setEmail(resultSet.getString("email"));
        return usuario;
    }

    @Override
    public Usuario porUsername(String username) throws SQLException {
        Usuario usuario = null;
        String sql = "select * from usuarios where username = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1, username);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    usuario = new Usuario();
                    usuario.setId(resultSet.getLong("id"));
                    usuario.setUsername(resultSet.getString("username"));
                    usuario.setPassword(resultSet.getString("password"));
                    usuario.setEmail(resultSet.getString("email"));

                }
            }
        }
        return usuario;
    }
}
