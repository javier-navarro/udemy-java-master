package org.jnavarro.ejemplos.list;

import org.jnavarro.ejemplos.modelo.Alumno;

import java.util.*;

public class EjemploListComparableComparator {
    public static void main(String[] args) {
        List<Alumno> sa = new ArrayList<>();
        sa.add(new Alumno("Pato", 5));
        sa.add(new Alumno("Diego", 6));
        sa.add(new Alumno("Sonia", 2));
        sa.add(new Alumno("Tiago", 7));
        sa.add(new Alumno("Talia", 2));
        sa.add(new Alumno("Sonia", 2));

        Collections.sort(sa);
        //ordenamiento con java8
        //sa.sort(Comparator.comparing((Alumno a)-> a.getNombre()));
        sa.sort(Comparator.comparing(Alumno::getNombre).reversed());
        System.out.println(sa);

        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("Iterando con stream foreach");
        System.out.println("==========================================");

        sa.forEach(System.out::println);
    }
}
