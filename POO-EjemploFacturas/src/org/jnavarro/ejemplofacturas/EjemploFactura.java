package org.jnavarro.ejemplofacturas;

import org.jnavarro.ejemplofacturas.model.Cliente;
import org.jnavarro.ejemplofacturas.model.Factura;
import org.jnavarro.ejemplofacturas.model.ItemFactura;
import org.jnavarro.ejemplofacturas.model.Producto;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setRut("18346429-9");
        cliente.setNombre("Benzema");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa descripcion de la factura");
        String desc = scanner.nextLine();
        Factura factura = new Factura(desc, cliente);

        Producto producto;
        String nombre;
        double precio;
        int cantidad;

        System.out.println();

        for (int i = 0; i <5 ; i++) {
            producto = new Producto();
            System.out.print("Ingrese producto n°: "+producto.getCodigo() + ": ");
            nombre = scanner.next();
            producto.setNombre(nombre);

            System.out.print("Ingrese el precio: ");
            precio = scanner.nextDouble();
            producto.setPrecio(precio);

            System.out.print("Ingrese la cantidad: ");
            cantidad = scanner.nextInt();

            ItemFactura item = new ItemFactura(cantidad,producto);
            factura.addItemFactura(item);

            System.out.println();
        }
        System.out.println(factura.generarDetalle());
    }
}