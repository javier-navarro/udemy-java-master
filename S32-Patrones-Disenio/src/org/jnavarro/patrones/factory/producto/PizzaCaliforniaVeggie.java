package org.jnavarro.patrones.factory.producto;

import org.jnavarro.patrones.factory.PizzaProducto;

public class PizzaCaliforniaVeggie extends PizzaProducto {

    public PizzaCaliforniaVeggie() {
        super();
        nombre = "Pizza Veggie California";
        masa = "masa delgada veggie";
        salsa = "Salsa BBQ";
        ingredientes.add("Queso veggie");
        ingredientes.add("Tomate");
        ingredientes.add("Aceitunas");
        ingredientes.add("Espinacas");
        ingredientes.add("Champiñones");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 20min a 180°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas rectangulares.");
    }
}
