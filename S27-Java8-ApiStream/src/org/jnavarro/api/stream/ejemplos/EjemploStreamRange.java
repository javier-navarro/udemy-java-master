package org.jnavarro.api.stream.ejemplos;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

/*
* RANGE: SIRVE PARA MANEJAR RANGOS
*  RANGE-CLOSED : INCLUYE EL ULTIMO DIGITO DEL RANGO, EL OTRO NO
*
* */
public class EjemploStreamRange {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(5,20).peek(System.out::println);

        //son lo mismo, funciona solo con intStream
        //int resultado = intStream.reduce(0,Integer::sum);
        /*
        int resultado = intStream.sum();
        System.out.println(resultado);

         */

        //MUY UTIL.
        IntSummaryStatistics stats = intStream.summaryStatistics();
        System.out.println("maximo: "+stats.getMax());
        System.out.println("minimo: "+stats.getMin());
        System.out.println("suma: "+stats.getSum());
        System.out.println("promedio: "+stats.getAverage());
        System.out.println("conteo: "+stats.getCount());


    }
}
