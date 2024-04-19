package org.jnavarro.bdd.jdbc.repositorio;

import org.jnavarro.bdd.jdbc.modelo.Categoria;
import org.jnavarro.bdd.jdbc.modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoReposiorioImpl implements Repositorio<Producto> {

    private Connection connection;

    public ProductoReposiorioImpl(Connection connection) {
        this.connection = connection;
    }

    public ProductoReposiorioImpl() {
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "select p.*, c.nombre as categoria " +
                "from productos as p inner join categorias c on p.categoria_id = c.id order by p.id asc";
        try(Statement statement =connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while(resultSet.next()) {
                Producto p = crearProducto(resultSet);
                productos.add(p);
            }
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        Producto producto = null;
        String sql = "select p.*, c.nombre as categoria from productos as p inner " +
                "join categorias c on p.categoria_id = c.id  where c.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                producto = crearProducto(resultSet);
            }
            resultSet.close();
        }
        return producto;
    }

    @Override
    public Producto guardar(Producto producto) throws SQLException {
        String sql;
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE PRODUCTOS SET NOMBRE =?,PRECIO =?, categoria_id=?, sku=? WHERE id=? ";
        } else {
            sql = "INSERT INTO PRODUCTOS(NOMBRE,PRECIO,categoria_id, sku, fecha_registro) VALUES(?,?,?,?,?)";
        }
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setLong(2, producto.getPrecio());
            preparedStatement.setLong(3,producto.getCategoria().getId());
            preparedStatement.setString(4,producto.getSku());
            if (producto.getId() != null && producto.getId() > 0) {
                preparedStatement.setLong(5,producto.getId());
            }else {
                System.out.println("entre aca...");
                preparedStatement.setDate(5, new Date(producto.getFechaRegitro().getTime()));
            }

            preparedStatement.executeUpdate();

            if ( producto.getId() == null) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                    if(resultSet.next()){
                        producto.setId(resultSet.getLong(1));
                    }
                }
            }
            return  producto;
        }



    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PRODUCTOS WHERE ID=?")){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        }
    }

    private static Producto crearProducto(ResultSet resultSet) throws SQLException {
        Producto p = new Producto();
        p.setId(resultSet.getLong("id"));
        p.setNombre(resultSet.getString("nombre"));
        p.setPrecio(resultSet.getInt("precio"));
        p.setFechaRegitro(resultSet.getDate("fecha_registro"));
        p.setSku(resultSet.getString("sku"));
        Categoria categoria = new Categoria();
        categoria.setId(resultSet.getLong("categoria_id"));
        categoria.setNombre(resultSet.getString("categoria"));
        p.setCategoria(categoria);
        return p;
    }
}
