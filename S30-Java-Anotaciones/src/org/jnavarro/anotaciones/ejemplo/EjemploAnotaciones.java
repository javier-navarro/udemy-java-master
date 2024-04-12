package org.jnavarro.anotaciones.ejemplo;

import org.jnavarro.anotaciones.ejemplo.models.Producto;
import org.jnavarro.anotaciones.ejemplo.procesador.JsonSerializador;

import java.time.LocalDate;

public class EjemploAnotaciones {
    public static void main(String[] args) {
        Producto producto = new Producto();
        producto.setFecha(LocalDate.now());
        producto.setNombre("mesa mala");
        producto.setPrecio(5000L);

        System.out.println("producto.toString() = " + producto.toString());

        System.out.println("json = " + JsonSerializador.convertirJson(producto));
    }
}
