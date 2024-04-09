package org.jnavarro.api.stream.ejemplos;

import java.util.stream.Stream;

/*
* reduce reduce el string a un unico resultado
*
* */
public class EjemploStreamReduceInt {
    public static void main(String[] args) {
        Stream<Integer> nombres = Stream.of(5,10,15,20);

        //son lo mismo
        //int resultado = nombres.reduce(0, (a,b) -> a+b);
        int resultado = nombres.reduce(0,Integer::sum);
        System.out.println(resultado);


    }
}
