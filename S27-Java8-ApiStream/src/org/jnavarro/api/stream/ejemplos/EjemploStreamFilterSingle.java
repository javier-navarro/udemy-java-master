package org.jnavarro.api.stream.ejemplos;

import org.jnavarro.api.stream.ejemplos.model.Usuario;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* filter: recibe rxpresion lambda predicate.
*   si es true cambia el listado nuevo
* */
public class EjemploStreamFilterSingle {
    public static void main(String[] args) {
        Stream<Usuario> nombres = Stream
                .of("mikasa ackerman","armin arlet","Eren Jaeger", "Yan Sho", "Sasha grey")
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                //.filter(u -> u.getNombre().equals("armin")) busca por nombre
                .filter(u -> u.getId().equals(4)) //busca por id
                .peek(System.out::println);

        Optional<Usuario> usuario = nombres.findFirst();
        System.out.println("usuario.get() = " + usuario.get());
    }
}
