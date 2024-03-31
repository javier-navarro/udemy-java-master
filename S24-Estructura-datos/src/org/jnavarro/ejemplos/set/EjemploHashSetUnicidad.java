package org.jnavarro.ejemplos.set;

import org.jnavarro.ejemplos.modelo.Alumno;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EjemploHashSetUnicidad {
    public static void main(String[] args) {
        Set<Alumno> sa = new HashSet<>();
        sa.add(new Alumno("Pato", 5));
        sa.add(new Alumno("Diego", 6));
        sa.add(new Alumno("Sonia", 2));
        sa.add(new Alumno("Tiago", 7));
        sa.add(new Alumno("Talia", 2));
        sa.add(new Alumno("Sonia", 2));
        System.out.println(sa);


        /* Funciona solo con el list
        System.out.println("utilizando for clasiso");
        for (int i = 0; i < sa.size(); i++) {
            Alumno alumno = alumno.get(i);
            System.out.println(alumno.toString());
        }
         */

        System.out.println("==========================================");
        System.out.println("Iterando con foreach");
        System.out.println("==========================================");

        for (Alumno a : sa){
            System.out.println(a.toString());
        }

        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("Iterando con while e iterator");
        System.out.println("==========================================");

        Iterator<Alumno> it = sa.iterator();
        while (it.hasNext()) {
            Alumno alumno = it.next();
            System.out.println(alumno.toString());
        }

        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("Iterando con stream foreach");
        System.out.println("==========================================");

        sa.forEach(System.out::println);
    }
}
