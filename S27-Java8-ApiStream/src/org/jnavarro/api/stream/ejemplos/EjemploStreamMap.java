package org.jnavarro.api.stream.ejemplos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* map: function
* peek: es para inspeccionar o mirar los elementos.
* */
public class EjemploStreamMap {
    public static void main(String[] args) {
        Stream<String> nombres = Stream.of("mikasa","armin","Eren", "Yan")
                //son lo mismo peek(System.out::println)
                .peek(e -> System.out.println(e)) // sirve para ver como va la consulta.
                //son lo mismo
                /*
                .map(nombre -> {
                   return nombre.toUpperCase();
                });
                 */
                .map(String::toUpperCase);
        //collect : para comvertir a lista tipo string, operador tipo final
        List<String> lista = nombres.collect(Collectors.toList());
        lista.forEach(System.out::println);
        //nombres.forEach(System.out::println);
    }
}
