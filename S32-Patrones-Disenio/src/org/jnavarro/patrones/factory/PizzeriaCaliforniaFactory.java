package org.jnavarro.patrones.factory;

import org.jnavarro.patrones.factory.producto.PizzaCaliforniaPeperoni;
import org.jnavarro.patrones.factory.producto.PizzaCaliforniaQueso;
import org.jnavarro.patrones.factory.producto.PizzaCaliforniaVeggie;

public class PizzeriaCaliforniaFactory extends PizzeriaZonaAbstractFactory{
    @Override
    PizzaProducto crearPizza(String tipo) {
         return switch (tipo){
            case "queso" -> new PizzaCaliforniaQueso();
            case "veggie" -> new PizzaCaliforniaVeggie();
            case "peperoni" -> new PizzaCaliforniaPeperoni();
             default -> null;
        };

    }
}
