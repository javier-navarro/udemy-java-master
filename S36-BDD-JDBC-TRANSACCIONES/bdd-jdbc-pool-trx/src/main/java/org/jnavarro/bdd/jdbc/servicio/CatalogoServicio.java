package org.jnavarro.bdd.jdbc.servicio;

import org.jnavarro.bdd.jdbc.modelo.Categoria;
import org.jnavarro.bdd.jdbc.modelo.Producto;
import org.jnavarro.bdd.jdbc.repositorio.CategoriaRepositorioImpl;
import org.jnavarro.bdd.jdbc.repositorio.ProductoReposiorioImpl;
import org.jnavarro.bdd.jdbc.repositorio.Repositorio;
import org.jnavarro.bdd.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CatalogoServicio implements Servicio{

    private Repositorio<Producto> productoRepositorio;
    private Repositorio<Categoria> categoriaRepositorio;

    public CatalogoServicio() {
        this.productoRepositorio = new ProductoReposiorioImpl();
        this.categoriaRepositorio = new CategoriaRepositorioImpl();
    }

    @Override
    public List<Producto> listar() throws SQLException {
        try(Connection connection = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConnection(connection);
            return productoRepositorio.listar();
        }
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        try(Connection connection = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConnection(connection);
            return productoRepositorio.porId(id);
        }
    }

    @Override
    public Producto guardar(Producto producto) throws SQLException {
        try(Connection connection = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConnection(connection);

            if(connection.getAutoCommit()){
                connection.setAutoCommit(false);
            }
            Producto nuevoProducto = null;
            try{
                productoRepositorio.guardar(producto);
                connection.commit();
            }catch (SQLException e){
                connection.rollback();
            }
            return producto;
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try(Connection connection = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConnection(connection);

            if(connection.getAutoCommit()){
                connection.setAutoCommit(false);
            }
            try{
                productoRepositorio.eliminar(id);
                connection.commit();
            }catch (SQLException e){
                connection.rollback();
            }
        }
    }

    @Override
    public List<Categoria> listarCategoria() throws SQLException {
        try(Connection connection = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConnection(connection);
            return categoriaRepositorio.listar();
        }
    }

    @Override
    public Categoria porIdCategoria(Long id) throws SQLException {
        try(Connection connection = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConnection(connection);
            return categoriaRepositorio.porId(id);
        }
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) throws SQLException {
        try(Connection connection = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConnection(connection);

            if(connection.getAutoCommit()){
                connection.setAutoCommit(false);
            }
            Categoria nuevaCategoria = null;
            try{
                nuevaCategoria = categoriaRepositorio.guardar(categoria);
                connection.commit();
            }catch (SQLException e){
                connection.rollback();
            }
            return nuevaCategoria;
        }
    }

    @Override
    public void eliminarCategoria(Long id) throws SQLException {
        try(Connection connection = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConnection(connection);

            if(connection.getAutoCommit()){
                connection.setAutoCommit(false);
            }
            try{
                categoriaRepositorio.eliminar(id);
                connection.commit();
            }catch (SQLException e){
                connection.rollback();
            }
        }
    }

    @Override
    public void guardarProductoConCategoria(Producto producto, Categoria categoria) throws SQLException {
        try(Connection connection = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConnection(connection);
            productoRepositorio.setConnection(connection);

            if(connection.getAutoCommit()){
                connection.setAutoCommit(false);
            }
            try{
                Categoria nuevaCategoria = categoriaRepositorio.guardar(categoria);
                producto.setCategoria(nuevaCategoria);
                productoRepositorio.guardar(producto);
                connection.commit();
            }catch (SQLException e){
                connection.rollback();
                e.printStackTrace();
            }
        }
    }
}
