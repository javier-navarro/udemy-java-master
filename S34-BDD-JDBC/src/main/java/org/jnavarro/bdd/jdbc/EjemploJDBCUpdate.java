package org.jnavarro.bdd.jdbc;

import org.jnavarro.bdd.jdbc.modelo.Categoria;
import org.jnavarro.bdd.jdbc.modelo.Producto;
import org.jnavarro.bdd.jdbc.repositorio.ProductoReposiorioImpl;
import org.jnavarro.bdd.jdbc.repositorio.ProductoRepositorio;
import org.jnavarro.bdd.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJDBCUpdate {

    public static void main(String[] args) {

        try (Connection connection = ConexionBaseDatos.getInstance()){
            ProductoRepositorio<Producto> repositorio = new ProductoReposiorioImpl();

            System.out.println("===================listar===============================");
            repositorio.listar().forEach(System.out::println);

            System.out.println("===================buscar por id===============================");
            System.out.println("buscando = "+ repositorio.porId(2L));

            System.out.println("===================Editar producto===============================");
            Producto producto = new Producto();
            producto.setId(21L);
            producto.setNombre("Teclado de gato");
            producto.setPrecio(4000);
            producto.setFechaRegitro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto modificado con exito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
