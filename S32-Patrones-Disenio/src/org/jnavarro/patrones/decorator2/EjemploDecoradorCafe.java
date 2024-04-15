package org.jnavarro.patrones.decorator2;

import org.jnavarro.patrones.decorator2.decorador2.ConChocolateDecorador;
import org.jnavarro.patrones.decorator2.decorador2.ConCremaDecorador;
import org.jnavarro.patrones.decorator2.decorador2.ConLecheDecorador;

public class EjemploDecoradorCafe {
    public static void main(String[] args) {
        Configurable moka = new Cafe( 7, "Cafe Mocha");
        Configurable cafe2 = new Cafe( 7, "Cafe Mocha");

        ConCremaDecorador crema = new ConCremaDecorador(moka);
        System.out.println("precio = " + crema.getPrecioBase());
        System.out.println("ingredientes = " + crema.getIngredientes());

        ConChocolateDecorador chocolate = new ConChocolateDecorador(moka);
        System.out.println("chocolate.getPrecioBase() = " + chocolate.getPrecioBase());
        System.out.println("chocolate.getIngredientes() = " + chocolate.getIngredientes());

        ConLecheDecorador leche = new ConLecheDecorador(chocolate);
        System.out.println("leche.getPrecioBase() = " + leche.getPrecioBase());
        System.out.println("leche.getIngredientes() = " + leche.getIngredientes());
        
        
    }
}
