package org.jnavarro.bdd.jdbc;

import org.jnavarro.bdd.jdbc.modelo.Producto;
import org.jnavarro.bdd.jdbc.repositorio.ProductoReposiorioImpl;
import org.jnavarro.bdd.jdbc.repositorio.ProductoRepositorio;
import org.jnavarro.bdd.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJDBCDelete {

    public static void main(String[] args) throws SQLException {

            ProductoRepositorio<Producto> repositorio = new ProductoReposiorioImpl();

            System.out.println("===================listar===============================");
            repositorio.listar().forEach(System.out::println);

            System.out.println("===================buscar por id===============================");
            System.out.println("buscando = "+ repositorio.porId(2L));

            System.out.println("===================Editar producto===============================");

            repositorio.eliminar(3L);
            System.out.println("Producto eliminado con exito");
            repositorio.listar().forEach(System.out::println);

    }
}
