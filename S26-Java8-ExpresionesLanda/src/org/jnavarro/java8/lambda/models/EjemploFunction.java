package org.jnavarro.java8.lambda.models;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EjemploFunction {
    public static void main(String[] args) {

        /* Function
        recibe parametros y devuelve valores 
        el primer parametro es el que recibe, el segundo es el que sale
        */
        
        Function<String,String> funcion1 = param -> "Hola que tal " + param;
        String resultado = funcion1.apply("Rengoku");
        System.out.println("resultado = " + resultado);

        //son lo mismo
        //Function<String,String> funcion2 = param -> param.toUpperCase();
        Function<String,String> funcion2 = String::toUpperCase;
        System.out.println(funcion2.apply("Tengen"));

        //acepta 2 parametros de entrada y 1 de salida.
        BiFunction<String,String,String> funcion3 = (a,b) -> a.toUpperCase().concat(b.toUpperCase());
        String resultado2 = funcion3.apply("Inoske", "Nezuko");
        System.out.println(resultado2);

        // son lo mismo BiFunction<String,String, Integer> funcion4  = (a,b) -> a.compareTo(b);
        BiFunction<String,String, Integer> funcion4  = String::compareTo;
        System.out.println(funcion4.apply("Javier", "javier"));

        BiFunction<String,String, String> funcion5  = String::concat;
        System.out.println(funcion5.apply("Javier", "javier"));
    }
}
