package org.jnavarro.tarea31;

import java.util.Arrays;
import java.util.List;

public class Tarea34profe {
    public static void main(String[] args) {
        //forma 1
        List<Producto> facturas = Arrays.asList(new Producto(9.99, 1), new Producto(19.99, 1.5), new Producto(4.99, 2));
        double sum = facturas.stream()
                .map(p -> p.getCantidad() * p.getPrecio())
                .reduce(0d, Double::sum);
        System.out.println("primera opcion: "+sum);

        //forma2
        List<Producto> facturas2 = Arrays.asList(new Producto(9.99, 1), new Producto(19.99, 1.5), new Producto(4.99, 2));

        double sum2 = facturas2.stream()
                .mapToDouble(x -> x.getCantidad() * x.getPrecio())
                .sum();

        System.out.println("segunda opcion: "+sum2);
    }
}
