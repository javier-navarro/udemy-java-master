package org.jnavarro.api.stream.ejemplos;

import org.jnavarro.api.stream.ejemplos.model.Usuario;

import java.util.stream.Stream;

/*
* filter: recibe rxpresion lambda predicate.
*   si es true cambia el listado nuevo
* */
public class EjemploStreamDistinctUsuario {
    public static void main(String[] args) {
        Stream<Usuario> nombres = Stream
                .of("mikasa ackerman","armin arlet","Eren Jaeger", "Yan Sho", "Sasha blouse","mikasa ackerman","mikasa ackerman")
                .distinct()
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]));

        nombres.forEach(System.out::println);
    }
}
