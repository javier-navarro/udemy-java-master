package org.jnavarro.apiservlet.webapp.headers.repositories;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import org.jnavarro.apiservlet.webapp.headers.configs.MysqlConn;
import org.jnavarro.apiservlet.webapp.headers.configs.Repositorio;
import org.jnavarro.apiservlet.webapp.headers.models.entities.Categoria;
import org.jnavarro.apiservlet.webapp.headers.models.entities.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repositorio
@RepositoryJdbc
public class ProductoRepositoryJdbcImpl implements Repository<Producto>{
    @Inject
    @MysqlConn
    private Connection conn;

    @Inject
    private Logger log;

    @PostConstruct
    public void inicializar(){
        log.info("Inicializando el beans "+this.getClass().getName());
    }

    @PreDestroy
    public void destruir(){
        log.info("Destruyendo el beans!"+this.getClass().getName());
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql ="SELECT p.*, c.nombre as categoria FROM PRODUCTOS AS P INNER JOIN CATEGORIAS AS C ON (P.CATEGORIA_ID = C.ID) order by p.id asc";
        try(Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                Producto p = getProducto(resultSet);

                productos.add(p);
            }
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        String sql = "SELECT P.*, C.NOMBRE AS CATEGORIA FROM PRODUCTOS AS P INNER JOIN CATEGORIAS AS C ON (P.CATEGORIA_ID = C.ID) WHERE P.ID= ?";
        Producto producto = null;

        try(PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setLong(1,id);
            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    producto = getProducto(resultSet);
                }
            }
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {
        String sql;

        if (producto.getId() != null && producto.getId() >0) {
            sql = "update productos set nombre=?, precio=?, sku=?, categoria_id=? where id=?";
        } else {
            sql = "insert into productos(nombre,precio,sku,categoria_id, fecha_registro) values (?,?,?,?,?)";
        }
        try( PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setInt(2,producto.getPrecio());
            preparedStatement.setString(3, producto.getSku());
            preparedStatement.setLong(4, producto.getCategoria().getId());

            if(producto.getId() != null && producto.getId() > 0){
                preparedStatement.setLong(5, producto.getId());
            }else {
                preparedStatement.setDate(5, Date.valueOf(producto.getFechaRegistro()));
            }
            preparedStatement.executeUpdate();

        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "delete from productos where id=?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        }
    }

    private static Producto getProducto(ResultSet resultSet) throws SQLException {
        Producto p = new Producto();
        p.setId(resultSet.getLong("id"));
        p.setNombre(resultSet.getString("nombre"));
        p.setPrecio(resultSet.getInt("precio"));
        Categoria c = new Categoria();
        c.setId(resultSet.getLong("categoria_id"));
        c.setNombre(resultSet.getString("categoria"));
        p.setCategoria(c);
        p.setSku(resultSet.getString("sku"));
        p.setFechaRegistro(resultSet.getDate("fecha_registro").toLocalDate());
        return p;
    }
}
