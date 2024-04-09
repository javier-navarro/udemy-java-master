package org.jnavarro.api.stream.ejemplos;

import org.jnavarro.api.stream.ejemplos.model.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

/*
* filter: recibe rxpresion lambda predicate.
*   si es true cambia el listado nuevo
* */
public class EjemploStreamFilterSingle2 {
    public static void main(String[] args) {
       Usuario usuario = Stream
                .of("mikasa ackerman","armin arlet","Eren Jaeger", "Yan Sho", "Sasha grey")
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                //.filter(u -> u.getNombre().equals("armin")) busca por nombre
                .filter(u -> u.getId().equals(10)) //busca por id
               //.findFirst().get(); //cuando encuentra se sale del ciclo.
               .findFirst().orElseGet(()-> new Usuario("no encontre","nada"));

        System.out.println("usuario = " + usuario);
    }
}
