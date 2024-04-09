package org.jnavarro.api.stream.ejemplos;

import org.jnavarro.api.stream.ejemplos.model.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

/*
* filter: recibe rxpresion lambda predicate.
*   VAMOS A FILTRART POR NOMBRES VACIOS
* */
public class EjemploStreamFilterEmpty {
    public static void main(String[] args) {
       long count = Stream
                .of("mikasa ackerman","","Eren Jaeger", "", "Sasha grey")
                .filter(String::isEmpty)
                .peek(System.out::println).
                count();
        System.out.println("count = " + count);
        
        

    }
}
