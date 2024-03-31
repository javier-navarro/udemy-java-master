package org.jnavarro.ejemplos.set;

import org.jnavarro.ejemplos.modelo.Alumno;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSetComparable {
    public static void main(String[] args) {
        //son lo mismo
        //Set<Alumno> sa = new TreeSet<>((a, b) -> b.getNombre().compareTo(a.getNombre()));
        Set<Alumno> sa = new TreeSet<>(Comparator.comparing(Alumno::getNota));
        sa.add(new Alumno("Pato", 5));
        sa.add(new Alumno("Diego", 6));
        sa.add(new Alumno("Sonia", 2));
        sa.add(new Alumno("Tiago", 7));
        sa.add(new Alumno("Talia", 2));
        sa.add(new Alumno("Lucas", 8));
        System.out.println(sa);
    }
}
