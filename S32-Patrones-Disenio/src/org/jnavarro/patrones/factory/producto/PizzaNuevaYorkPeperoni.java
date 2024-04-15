package org.jnavarro.patrones.factory.producto;

import org.jnavarro.patrones.factory.PizzaProducto;

public class PizzaNuevaYorkPeperoni extends PizzaProducto {
    public PizzaNuevaYorkPeperoni() {
        super();
        nombre = "pizza peperoni NY";
        masa = "delgada a la piedra";
        salsa = "salsa de tomate";
        ingredientes.add("Queso mozzarella");
        ingredientes.add("Extra peperoni");
        ingredientes.add("aceitunas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 40min a 90°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas en triangulos.");
    }
}
