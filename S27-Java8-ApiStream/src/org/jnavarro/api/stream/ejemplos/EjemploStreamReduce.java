package org.jnavarro.api.stream.ejemplos;

import java.util.stream.Stream;

/*
* reduce reduce el string a un unico resultado
*
* */
public class EjemploStreamReduce {
    public static void main(String[] args) {
        Stream<String> nombres = Stream.of("mikasa ackerman","armin arlet","Eren Jaeger", "Yan Sho", "Sasha grey","Eren Jaeger","Eren Jaeger")
                .distinct();
        
        String resultado = nombres.reduce("resultado = ", (a,b) -> a+" - "+b);
        System.out.println(resultado);


    }
}
