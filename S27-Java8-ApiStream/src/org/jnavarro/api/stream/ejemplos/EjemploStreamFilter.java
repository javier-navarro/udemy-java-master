package org.jnavarro.api.stream.ejemplos;

import org.jnavarro.api.stream.ejemplos.model.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* filter: recibe rxpresion lambda predicate.
*   si es true cambia el listado nuevo
* */
public class EjemploStreamFilter {
    public static void main(String[] args) {
        Stream<Usuario> nombres = Stream
                .of("mikasa ackerman","armin arlet","Eren Jaeger", "Yan Sho", "Sasha grey")
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("armin"))
                .peek(System.out::println);

        List<Usuario> lista = nombres.collect(Collectors.toList());
        lista.forEach(System.out::println);
    }
}
