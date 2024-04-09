package org.jnavarro.api.stream.ejemplos;

import org.jnavarro.api.stream.ejemplos.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamListToStream {
    public static void main(String[] args) {
        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("eren","jaeger"));
        lista.add(new Usuario("armin","arlet"));
        lista.add(new Usuario("mikasa","ackerman"));
        lista.add(new Usuario("yan","sho"));
        lista.add(new Usuario("mikasa","1"));
        lista.add(new Usuario("mikasa","2"));

        //transformamos la lista a stream
        Stream <String> nombres = lista.stream()
                .map(usuario -> usuario.getNombre().toUpperCase() //modificamos y concatenamos el nombre
                .concat(" ")
                        .concat(usuario.getApellido().toUpperCase()))
                .flatMap(nombre -> { //hacemos un filtro
                    if (nombre.contains("mikasa".toUpperCase())) {
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .map(String::toLowerCase)
                .peek(System.out::println);
        System.out.println(nombres.count());


    }
}
