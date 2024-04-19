package org.jnavarro.bdd.jdbc;

import org.jnavarro.bdd.jdbc.modelo.Categoria;
import org.jnavarro.bdd.jdbc.modelo.Producto;
import org.jnavarro.bdd.jdbc.repositorio.ProductoReposiorioImpl;
import org.jnavarro.bdd.jdbc.repositorio.ProductoRepositorio;
import org.jnavarro.bdd.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJDBCTrx {

    public static void main(String[] args) throws SQLException {

        try (Connection connection = ConexionBaseDatos.getInstance()) {
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }

            try {
                ProductoRepositorio<Producto> repositorio = new ProductoReposiorioImpl();

                System.out.println("===================listar===============================");
                repositorio.listar().forEach(System.out::println);

                System.out.println("===================buscar por id===============================");
                System.out.println("buscando = " + repositorio.porId(2L));

                System.out.println("===================insertar nuevo ===============================");
                Producto producto = new Producto();
                producto.setNombre("Teclado mecanico");
                producto.setPrecio(6000);
                producto.setFechaRegitro(new Date());
                Categoria categoria = new Categoria();
                categoria.setId(1L);
                producto.setCategoria(categoria);
                producto.setSku("a125");
                repositorio.guardar(producto);
                System.out.println("Producto guardado con exito");
                repositorio.listar().forEach(System.out::println);

                System.out.println("===================Editar producto===============================");
                producto = new Producto();
                producto.setId(21L);
                producto.setNombre("Teclado de vikings");
                producto.setPrecio(4000);
                producto.setFechaRegitro(new Date());
                producto.setSku("a1");
                categoria = new Categoria();
                categoria.setId(3L);
                producto.setCategoria(categoria);
                repositorio.guardar(producto);
                System.out.println("Producto modificado con exito");
                repositorio.listar().forEach(System.out::println);
                connection.commit();

            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }

        }

    }
}
