package org.jnavarro.patrones.factory;

import org.jnavarro.patrones.factory.producto.PizzaNuevaYorkItaliana;
import org.jnavarro.patrones.factory.producto.PizzaNuevaYorkPeperoni;
import org.jnavarro.patrones.factory.producto.PizzaNuevaYorkVeggie;

public class PizzeriaNewYorkFactory  extends PizzeriaZonaAbstractFactory{
    @Override
    PizzaProducto crearPizza(String tipo) {
        PizzaProducto pizzaProducto = null;
        switch (tipo){
            case "veggie":
                pizzaProducto = new PizzaNuevaYorkVeggie();
                break;
            case "peperoni":
                pizzaProducto = new PizzaNuevaYorkPeperoni();
                break;
            case "italiana":
                pizzaProducto = new PizzaNuevaYorkItaliana();
                break;
        }
        return pizzaProducto;
    }
}
