package org.jnavarro.patrones.factory;

abstract public class PizzeriaZonaAbstractFactory {
    public PizzaProducto ordenarPizza(String tipo){
        PizzaProducto pizzaProducto = crearPizza(tipo);
            System.out.println("-------------------Fabricando---------------: "+pizzaProducto.getNombre());
            pizzaProducto.preparar();
            pizzaProducto.cocinar();
            pizzaProducto.cortar();
            pizzaProducto.empaquetar();
            return pizzaProducto;
    }

    abstract PizzaProducto crearPizza(String tipo);
}
