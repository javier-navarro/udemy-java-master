package org.jnavarro.patrones.factory.producto;

import org.jnavarro.patrones.factory.PizzaProducto;

public class PizzaNuevaYorkItaliana extends PizzaProducto {

    public PizzaNuevaYorkItaliana() {
        super();
        nombre = "Pizza New York Italiana";
        masa = "masa gruesa";
        salsa = "Salsa tomate italiano con carne";
        ingredientes.add("Queso mozarrella");
        ingredientes.add("Aceitunas");
        ingredientes.add("jamon");
        ingredientes.add("choricillo");
        ingredientes.add("Champiñones");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 30min a 120°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triangulos grandes.");
    }
}
