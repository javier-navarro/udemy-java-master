package org.jnavarro.api.stream.ejemplos;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class EjemploStreamInfinitoGenerate {
    public static void main(String[] args) {

        /* generate
        * genera de forma infinita
        * se puede limitar a traves de limit.
        * */

        //genera de forma infinita
        //se puede limitar.
        AtomicInteger contador = new AtomicInteger(0);
        Stream.generate(()-> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return contador.incrementAndGet();
        })
                .limit(20)
                .forEach(System.out::println);
    }
}
