package org.jnavarro.java8.lambda;

import org.jnavarro.java8.lambda.aritmetica.Aritmetica;
import org.jnavarro.java8.lambda.aritmetica.Calculdora;

public class EjemploInterfaceFunctional {
    public static void main(String[] args) {
        //son lo mismo
        Aritmetica suma = Double::sum;
       // Aritmetica suma = (a,b) -> a+b;
        Aritmetica resta = (a,b) -> a-b;

        Calculdora calculdora = new Calculdora();

        System.out.println(calculdora.computar(10,5,suma));
        System.out.println(calculdora.computar(10,5,resta));
        System.out.println(calculdora.computar(10,5, (a,b) -> a*b));

        System.out.println(calculdora.computarConBiFunction(10,5,(a,b) -> a+b));
    }
}
