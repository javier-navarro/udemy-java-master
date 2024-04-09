package org.jnavarro.tarea31;

import java.util.Arrays;
import java.util.Collections;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/*
Obtener el numero mayor en un arreglo con programación funcional lambda y api stream
 */
public class Tarea32 {
//    public static void main(String[] args) {
//
//
//        int [] arregloNumeros = new int [10];
//        Integer[] arreglo2 = new Integer[5];
//        arreglo2[0] = 16;
//        arreglo2[1] = 163;
//        arreglo2[2] = 84;
//        arreglo2[3] = 96;
//        arreglo2[4] = 32;
//
//        /*
//        Stream<Integer> arrayNumeros = Stream
//                .of(16,163,84,96,32)
//                .map(Integer::intValue)
//                ;
//
//         */
//        Stream<Integer> arrayNumeros = Stream.of(arreglo2);
//        Arrays.sort(arreglo2,Collections.reverseOrder());
//        arrayNumeros.forEach(System.out::println);
//        Optional<Integer> numeroMayor = arrayNumeros.findFirst();
//
//        //Optional<Integer> numeroMayor = arrayNumeros.findFirst();
//        System.out.println("numeroMayor = " + numeroMayor);
//
//
//    }

    public static void main(String[] args) {
        // la función lambda que obtiene el numero mayor del arreglo usando api stream en su implementación
        Function<Integer[], Integer> max = arr -> Arrays.stream(arr).reduce(0, (ac, e) -> ac > e? ac: e);

        int resultado = max.apply(new Integer[]{1, 78, -1700, 2500, 0, 2000, 54, 2});
        System.out.println(resultado);
    }
}
