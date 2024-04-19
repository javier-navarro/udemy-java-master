package org.jnavarro.bdd.jdbc;

import org.jnavarro.bdd.jdbc.modelo.Categoria;
import org.jnavarro.bdd.jdbc.modelo.Producto;
import org.jnavarro.bdd.jdbc.repositorio.ProductoReposiorioImpl;
import org.jnavarro.bdd.jdbc.repositorio.ProductoRepositorio;
import org.jnavarro.bdd.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJDBC {
    //segunda forma de hacerlo.
    public static void main(String[] args) {

            ProductoRepositorio<Producto> repositorio = new ProductoReposiorioImpl();

            System.out.println("===================listar===============================");
            repositorio.listar().forEach(System.out::println);

            System.out.println("===================buscar por id===============================");
            System.out.println("buscando = "+ repositorio.porId(2L));

            System.out.println("===================insertar nuevo ===============================");
            Producto producto = new Producto();
            producto.setNombre("Teclado mecanico");
            producto.setPrecio(6000);
            producto.setFechaRegitro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(1L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto guardado con exito");
            repositorio.listar().forEach(System.out::println);
        }
    }
