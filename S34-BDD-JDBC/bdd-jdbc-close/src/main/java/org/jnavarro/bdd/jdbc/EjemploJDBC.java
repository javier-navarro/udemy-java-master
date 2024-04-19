package org.jnavarro.bdd.jdbc;

import org.jnavarro.bdd.jdbc.modelo.Categoria;
import org.jnavarro.bdd.jdbc.modelo.Producto;
import org.jnavarro.bdd.jdbc.repositorio.ProductoReposiorioImpl;
import org.jnavarro.bdd.jdbc.repositorio.ProductoRepositorio;
import org.jnavarro.bdd.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJDBC {
    public static void main2(String[] args) {
        String url = "jdbc:mysql://localhost:3307/java_curso?serverTimezone=UTC";
        String username = "root";
        String password = "7979";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM  productos");

            while (resultSet.next()){
                System.out.print(resultSet.getInt("id"));
                System.out.print(" | ");
                System.out.print(resultSet.getString("nombre"));
                System.out.print(" | ");
                System.out.print(resultSet.getInt("precio"));
                System.out.print(" | ");
                System.out.println(resultSet.getDate("fecha_registro"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

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
