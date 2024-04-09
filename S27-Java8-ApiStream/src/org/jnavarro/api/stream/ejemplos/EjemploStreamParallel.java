package org.jnavarro.api.stream.ejemplos;

import org.jnavarro.api.stream.ejemplos.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/*
PARALLEL : SIRVE PARA CUANDO HAY QUE PROCESAR MUCHOS DATOS, HACERLO DE FORMA PARALELA PARA BAJAR LOS TIEMPOS.
* */
public class EjemploStreamParallel {
    public static void main(String[] args) {
        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("eren","jaeger"));
        lista.add(new Usuario("armin","arlet"));
        lista.add(new Usuario("mikasa","ackerman"));
        lista.add(new Usuario("yan","sho"));
        lista.add(new Usuario("mikasa","1"));
        lista.add(new Usuario("mikasa","2"));

        long t1 = System.currentTimeMillis();
        String resultado = lista.stream()
                .parallel() // hace que se ejecuten en paralelo
                .map(usuario -> usuario.toString().toUpperCase())
                .peek(n-> { //revisamos los diferentes threads que realizan las consultas.
                    System.out.println("nombre del thread: "+Thread.currentThread().getName() + " - "+n);
                })
                .flatMap(nombre -> { //hacemos un filtro
                    try {
                        TimeUnit.SECONDS.sleep(1); //le damos un delay
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (nombre.contains("mikasa".toUpperCase())) {
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .findAny().orElse("");

        long t2 = System.currentTimeMillis();
        System.out.println("tiempo total: "+(t2-t1));
        System.out.println(resultado);


    }
}
