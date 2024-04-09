package org.jnavarro.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStream {
    public static void main(String[] args) {
        
        Stream<String> nombres = Stream.of("mikasa","armin","Eren", "Yan");

        //nombres.forEach(System.out::println);
        nombres.forEach(e -> {
            System.out.println(e.toString()); //es lo mismo que la linea anterior.
        });
        System.out.println("=======================================");
        String[]array = {"mikasa","armin","Eren", "Yan"};
        Stream<String> nombres2 = Arrays.stream(array);
        nombres2.forEach(System.out::println);

        //generado desde un builder
        System.out.println("=================generado desde builder======================");
        Stream<String> nombresBuilder = Stream.<String> builder()
                .add("mikasa")
                .add("armin")
                .add("Eren")
                .add("Yan")
                .build();
        nombresBuilder.forEach(System.out::println);

        //generado desde arraylist
        System.out.println("=================generado desde arraylist======================");
        List<String> lista = new ArrayList<>();
        lista.add("mikasa");
        lista.add("armin");
        lista.add("eren");
        lista.add("yan");

        Stream<String> nombresArrayList = lista.stream();
        nombresArrayList.forEach(System.out::println);
    }
}
