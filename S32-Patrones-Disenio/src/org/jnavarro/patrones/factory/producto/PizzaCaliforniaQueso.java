package org.jnavarro.patrones.factory.producto;

import org.jnavarro.patrones.factory.PizzaProducto;

public class PizzaCaliforniaQueso extends PizzaProducto {

    public PizzaCaliforniaQueso() {
        super();
        nombre = "Pizza California Queso";
        masa = "masa a la piedra delgada";
        salsa = "Salsa tomate rucula";
        ingredientes.add("Extra queso mozzarella");
        ingredientes.add("cebolla");
        ingredientes.add("queso azul");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 35min a 100°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando en pequeños triangulos");
    }
}
