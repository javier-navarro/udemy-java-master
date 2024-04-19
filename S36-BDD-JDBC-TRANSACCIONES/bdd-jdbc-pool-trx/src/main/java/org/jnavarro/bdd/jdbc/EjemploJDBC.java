package org.jnavarro.bdd.jdbc;

import org.jnavarro.bdd.jdbc.modelo.Categoria;
import org.jnavarro.bdd.jdbc.modelo.Producto;
import org.jnavarro.bdd.jdbc.repositorio.CategoriaRepositorioImpl;
import org.jnavarro.bdd.jdbc.repositorio.ProductoReposiorioImpl;
import org.jnavarro.bdd.jdbc.repositorio.Repositorio;
import org.jnavarro.bdd.jdbc.servicio.CatalogoServicio;
import org.jnavarro.bdd.jdbc.servicio.Servicio;
import org.jnavarro.bdd.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJDBC {
    public static void main(String[] args) throws SQLException {

        Servicio servicio = new CatalogoServicio();

        System.out.println("===================listar===============================");
        servicio.listar().forEach(System.out::println);

        System.out.println("===================insertando categoria===============================");
        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminacion");

        System.out.println("===================insertar nuevo ===============================");
        Producto producto = new Producto();
        producto.setNombre("Lampara led");
        producto.setPrecio(990);
        producto.setFechaRegitro(new Date());
        producto.setSku("trx");

        servicio.guardarProductoConCategoria(producto,categoria);
        System.out.println("Producto guardado con exito" + producto.getId());
        servicio.listar().forEach(System.out::println);


    }
}
