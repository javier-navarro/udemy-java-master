package org.jnavarro.api.stream.ejemplos;

import org.jnavarro.api.stream.ejemplos.model.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
* .mapToInt(): recibe rxpresion lambda predicate.
* Combierte el flujo hacia entero
* */
public class EjemploStreamDistinctUsuarioSum {
    public static void main(String[] args) {
        IntStream largoNombres = Stream
                .of("mikasa ackerman","armin arlet","Eren Jaeger", "Yan Sho", "Sasha blouse","mikasa ackerman","mikasa ackerman")
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .distinct()
                .mapToInt(u -> u.toString().length())
                .peek(System.out::println);

        //largoNombres.forEach(System.out::println);
        IntSummaryStatistics intSummaryStatistics = largoNombres.summaryStatistics();
        System.out.println("total = "+intSummaryStatistics.getSum());
        System.out.println("maximo = "+intSummaryStatistics.getMax());
        System.out.println("minimo = "+intSummaryStatistics.getMin());
        System.out.println("promedio  = "+intSummaryStatistics.getAverage());
    }
}
