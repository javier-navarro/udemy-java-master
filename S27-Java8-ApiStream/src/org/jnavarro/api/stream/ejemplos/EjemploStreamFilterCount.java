package org.jnavarro.api.stream.ejemplos;

import org.jnavarro.api.stream.ejemplos.model.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
* anyMatch: return boolean
*   recorre la lista, y al encontrar el valor sale y devuelve true
*   si no encuentra nada, recorre la lista y devuelve false
* */
public class EjemploStreamFilterCount {
    public static void main(String[] args) {
       long count  = Stream
                .of("mikasa ackerman","armin arlet","Eren Jaeger", "Yan Sho", "Sasha grey")
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
               .peek(System.out::println)
               .count();

        System.out.println(count);

    }
}
