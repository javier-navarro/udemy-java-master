package org.jnavarro.patrones.factory.ejemplo;

import org.jnavarro.patrones.factory.PizzaProducto;
import org.jnavarro.patrones.factory.PizzeriaCaliforniaFactory;
import org.jnavarro.patrones.factory.PizzeriaNewYorkFactory;
import org.jnavarro.patrones.factory.PizzeriaZonaAbstractFactory;

public class EjemploFactory {
    public static void main(String[] args) {
        PizzeriaZonaAbstractFactory newYork = new PizzeriaNewYorkFactory();
        PizzeriaZonaAbstractFactory california = new PizzeriaCaliforniaFactory();

        PizzaProducto pizza = california.ordenarPizza("queso");
        System.out.println("pizza.getNombre() = " + pizza.getNombre());

        System.out.println("\n");
        pizza = newYork.ordenarPizza("veggie");
        System.out.println("pizza.getNombre() = " + pizza.getNombre());
    }
    
    
    
    
}
