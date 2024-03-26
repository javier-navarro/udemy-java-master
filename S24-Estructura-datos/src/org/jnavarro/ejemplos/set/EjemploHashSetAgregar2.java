package org.jnavarro.ejemplos.set;

import java.util.*;

public class EjemploHashSetAgregar2 {
    public static void main(String[] args) {


        /*            */
        String[] peces = { "Corvina", "Lenguado", "Pejerrey", "Corvina", "Robalo", "Atun","Lenguado"};
        Set<String> unicos = new HashSet<>();
        Set<String> duplicados = new HashSet<>();
        for (String pez: peces){
            if(!unicos.add(pez)){
                duplicados.add(pez);

                System.out.println("Elemento duplicado = " + pez);
            }
        }
        unicos.removeAll(duplicados);
        System.out.println(" elementos no duplicados = " + unicos);
        System.out.println(" elementos  duplicados = " + duplicados);

    }
}