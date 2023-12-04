package org.jnavarro.poointerfaces;

import org.jnavarro.poointerfaces.modelo.Cliente;
import org.jnavarro.poointerfaces.modelo.Producto;
import org.jnavarro.poointerfaces.repositorio.Direccion;
import org.jnavarro.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.jnavarro.poointerfaces.repositorio.OrdenableRepositorio;
import org.jnavarro.poointerfaces.repositorio.PaginableRepositorio;
import org.jnavarro.poointerfaces.repositorio.lista.ClienteListRepositorio;
import org.jnavarro.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class MainProductos {
    public static void main(String[] args) {

        OrdenablePaginableCrudRepositorio<Producto> repositorio = new ProductoListRepositorio();
        repositorio.crearCliente(new Producto("Mesa", 10000));
        repositorio.crearCliente(new Producto("Vaso", 2500));
        repositorio.crearCliente(new Producto("Telefono", 100000));
        repositorio.crearCliente(new Producto("lampara", 25000));

        List<Producto> productos = repositorio.listar();
        productos.forEach(pro -> System.out.println(pro));
        System.out.println("\n");

        System.out.println("===== paginable ======");
        List<Producto> paginable = ((PaginableRepositorio)repositorio).listar(1,3);
        paginable.forEach(cliente -> System.out.println(cliente));
        System.out.println("\n");

        System.out.println("===== Ordenar x nombre ASC ======");
        List<Producto> clientesOrdenadosAsc = ((OrdenableRepositorio)repositorio).listar("nombre", Direccion.ASC);
        for (Producto pro: clientesOrdenadosAsc){
            System.out.println(pro);
        }
        System.out.println("\n");

        System.out.println("===== Ordenar x nombre DESC ======");
        List<Producto> clientesOrdenadosDesc = ((OrdenableRepositorio)repositorio).listar("nombre", Direccion.DESC);
        for (Producto pro: clientesOrdenadosDesc){
            System.out.println(pro);
        }
        System.out.println("\n");

        System.out.println("===== Ordenar x apellido ASC ======");
        List<Producto> clientesOrdenadosApellidoAsc = ((OrdenableRepositorio)repositorio).listar("apellido", Direccion.ASC);
        for (Producto pro: clientesOrdenadosApellidoAsc){
            System.out.println(pro);
        }
        System.out.println("\n");

        System.out.println("===== Ordenar x apellido DESC ======");
        List<Producto> clientesOrdenadosApellidoDesc = ((OrdenableRepositorio)repositorio).listar("apellido", Direccion.DESC);
        for (Producto pro: clientesOrdenadosApellidoDesc){
            System.out.println(pro);
        }
        System.out.println("\n");

        System.out.println("===== Editar ======");
        Producto productoActualizado = new Producto("Zlatan", 50000);
        productoActualizado.setId(3);
        repositorio.editarCliente(productoActualizado);
        Producto zlatan = (Producto) repositorio.porId(3);
        System.out.println(zlatan);
        System.out.println("\n");

        System.out.println("===== eliminar ======");
        repositorio.eliminarCliente(3);
        repositorio.listar().forEach(System.out::println);

        System.out.println("\n");

        System.out.println("===== total ======");
        repositorio.total();
    }
}