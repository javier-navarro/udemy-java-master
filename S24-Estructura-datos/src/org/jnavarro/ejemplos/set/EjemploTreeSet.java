package org.jnavarro.ejemplos.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {
        Set<String> treeset = new TreeSet<>((a,b) -> b.compareTo(a));
        treeset.add("uno");
        treeset.add("dos");
        treeset.add("tres");
        treeset.add("tres");
        treeset.add("cuatro");
        treeset.add("cinco");

        System.out.println("treeset = " + treeset);
        
        Set<Integer> numeros = new TreeSet<>(Comparator.reverseOrder());
        numeros.add(1);
        numeros.add(18);
        numeros.add(14);
        numeros.add(20);
        numeros.add(7);
        numeros.add(8);
        System.out.println("numeros = " + numeros);
    }
}
