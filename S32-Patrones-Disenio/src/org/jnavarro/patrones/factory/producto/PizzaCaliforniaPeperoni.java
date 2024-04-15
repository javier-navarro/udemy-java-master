package org.jnavarro.patrones.factory.producto;

import org.jnavarro.patrones.factory.PizzaProducto;

public class PizzaCaliforniaPeperoni extends PizzaProducto {
    public PizzaCaliforniaPeperoni() {
        super();
        nombre = "pizza california peperoni";
        masa = "masa  a la piedra gruesa ";
        salsa = "salsa de tomate";
        ingredientes.add("Extra queso mozzarella");
        ingredientes.add("peperoni");
        ingredientes.add("aceitunas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 50min a 55°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequeños rectangulos.");
    }
}
