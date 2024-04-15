package org.jnavarro.patrones.factory.producto;

import org.jnavarro.patrones.factory.PizzaProducto;

public class PizzaNuevaYorkVeggie extends PizzaProducto {

    public PizzaNuevaYorkVeggie() {
        super();
        nombre = "Pizza Veggie New York";
        masa = "masa integral veggie";
        salsa = "Salsa tomate";
        ingredientes.add("Queso veggie");
        ingredientes.add("Tomate");
        ingredientes.add("Aceitunas");
        ingredientes.add("Espinacas");
        ingredientes.add("Champiñones");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 25min a 150°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas cuadradas.");
    }
}
