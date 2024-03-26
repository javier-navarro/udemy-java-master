package org.jnavarro.ejemplos.set;

import java.util.*;

public class EjemploHashSetAgregar {
    public static void main(String[] args) {

        //hashset
        Set<String> hashSet = new HashSet<>();
        hashSet.add("uno");
        hashSet.add("dos");
        hashSet.add("tres");
        hashSet.add("cuatro");
        hashSet.add("cinco");
        System.out.println("hashSet = " + hashSet);

        boolean b = hashSet.add("tres");
        System.out.println("permiten duplicados ? = " + b);
        System.out.println("hashSet = " + hashSet);
        System.out.println('\n');

        //arraylist
        List<String> lista = new ArrayList<>();
        lista.add("uno");
        lista.add("dos");
        lista.add("tres");
        lista.add("cuatro");
        lista.add("cinco");
        System.out.println("lista = " + lista);

        boolean b2 = lista.add("tres");

        Collections.sort(lista);
        System.out.println("permiten duplicados ? = " + b2);
        System.out.println("lista = " + lista);
        System.out.println('\n');

        /*            */
        String[] peces = { "Corvina", "Lenguado", "Pejerrey", "Corvina", "Robalo", "Atun","Lenguado"};
        Set<String> unicos = new HashSet<>();
        for (String pez: peces){
            if(!unicos.add(pez)){
                System.out.println("Elemento duplicado = " + pez);
            }
        }
        System.out.println(unicos.size() + " elementos no duplicados = " + unicos);

    }
}