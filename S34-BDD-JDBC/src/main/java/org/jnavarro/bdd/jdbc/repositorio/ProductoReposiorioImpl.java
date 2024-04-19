package org.jnavarro.bdd.jdbc.repositorio;

import org.jnavarro.bdd.jdbc.modelo.Categoria;
import org.jnavarro.bdd.jdbc.modelo.Producto;
import org.jnavarro.bdd.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoReposiorioImpl implements ProductoRepositorio<Producto>{

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        String sql = "select p.*, c.nombre as categoria " +
                "from productos as p inner join categorias c on p.categoria_id = c.id order by p.id asc";
        try(Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while(resultSet.next()) {
                Producto p = crearProducto(resultSet);
                productos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) {
        Producto producto = null;
        String sql = "select p.*, c.nombre as categoria from productos as p inner " +
                "join categorias c on p.categoria_id = c.id  where c.id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                producto = crearProducto(resultSet);
            }
            resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) {
        String sql;
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE PRODUCTOS SET NOMBRE =?,PRECIO =?, categoria_id=? WHERE id=? ";
        } else {
            sql = "INSERT INTO PRODUCTOS(NOMBRE,PRECIO,categoria_id, FECHA_REGISTRo) VALUES(?,?,?,?)";
        }
        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setLong(2, producto.getPrecio());
            preparedStatement.setLong(3,producto.getCategoria().getId());
            if (producto.getId() != null && producto.getId() > 0) {
                preparedStatement.setLong(4,producto.getId());
            }else {
                System.out.println("entre aca...");
                preparedStatement.setDate(4, new Date(producto.getFechaRegitro().getTime()));
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(Long id) {
        try(PreparedStatement preparedStatement = getConnection().prepareStatement("DELETE FROM PRODUCTOS WHERE ID=?")){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Producto crearProducto(ResultSet resultSet) throws SQLException {
        Producto p = new Producto();
        p.setId(resultSet.getLong("id"));
        p.setNombre(resultSet.getString("nombre"));
        p.setPrecio(resultSet.getInt("precio"));
        p.setFechaRegitro(resultSet.getDate("fecha_registro"));
        Categoria categoria = new Categoria();
        categoria.setId(resultSet.getLong("categoria_id"));
        categoria.setNombre(resultSet.getString("categoria"));
        p.setCategoria(categoria);
        return p;
    }
}
