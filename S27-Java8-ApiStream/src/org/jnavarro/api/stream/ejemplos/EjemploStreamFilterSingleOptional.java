package org.jnavarro.api.stream.ejemplos;

import org.jnavarro.api.stream.ejemplos.model.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

/*
* filter: recibe rxpresion lambda predicate.
*   si es true cambia el listado nuevo
* */
public class EjemploStreamFilterSingleOptional {
    public static void main(String[] args) {
        Stream<Usuario> nombres = Stream
                .of("mikasa ackerman","armin arlet","Eren Jaeger", "Yan Sho", "Sasha grey")
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("mikasa"))
                .peek(System.out::println);

        Optional<Usuario> usuario = nombres.findFirst();
        //son lo mismo
        System.out.println("resultado= " + usuario.orElse(new Usuario("no encontre", "nada")));
        System.out.println(usuario.orElseGet(()-> new Usuario("no encontre", "nada")));
        //orElseThrow -> lanza exception
        System.out.println(usuario.orElseThrow());

        //isPresent: si es que esta presente

    }
}
