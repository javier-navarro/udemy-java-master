package org.jnavarro.api.stream.ejemplos;

import org.jnavarro.api.stream.ejemplos.model.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* flatmap: es otro tipo de filtro
*   deveulve varias salidas, por cada elemento devuelve un string separado
* */
public class EjemploStreamFlatMap {
    public static void main(String[] args) {
        Stream<Usuario> nombres = Stream
                .of("mikasa ackerman","armin arlet","Eren Jaeger", "Yan Sho", "Sasha grey")
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .flatMap(u->{
                    if (u .getNombre().equalsIgnoreCase("mikasa")) {
                        return Stream.of(u);
                    }
                    return Stream.empty();
                })
                .peek(System.out::println);

        //nombres.forEach(System.out::println);
        System.out.println("total: "+nombres.count());
    }
}
