package org.jnavarro.api.stream.ejemplos;

import org.jnavarro.api.stream.ejemplos.model.Usuario;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* map: function
* peek: es para inspeccionar o mirar los elementos.
* */
public class EjemploStreamMapModel {
    public static void main(String[] args) {
        Stream<Usuario> nombres = Stream
                .of("mikasa ackerman","armin arlet","Eren Jaeger", "Yan Sho")
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .peek(System.out::println)
                .map(usuario -> {
                    String nombre = usuario.getNombre().toUpperCase();
                    usuario.setNombre(nombre);
                    return usuario;
                });

        //collect : para comvertir a lista tipo string, operador tipo final
        List<Usuario> lista = nombres.collect(Collectors.toList());
        lista.forEach(System.out::println);
        //nombres.forEach(System.out::println);
    }
}
