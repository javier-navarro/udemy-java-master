package org.jnavarro.api.stream.ejemplos;

import org.jnavarro.api.stream.ejemplos.model.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

/*
* distinct toma en cuenta solo los elementos distintos
*
* */
public class EjemploStreamDistinct {
    public static void main(String[] args) {
        Stream<String> nombres = Stream.of("mikasa ackerman","armin arlet","Eren Jaeger", "Yan Sho", "Sasha grey","Eren Jaeger","Eren Jaeger")
                .distinct();
        nombres.forEach(System.out::println);


    }
}
