package org.jnavarro.ejemplos.list;

import org.jnavarro.ejemplos.modelo.Alumno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EjemploArrayList {
    public static void main(String[] args) {
        List<Alumno> al = new ArrayList<>();
        System.out.println(al + ", size = " + al.size());
        System.out.println("esta vacia = " + al.isEmpty());
        al.add(new Alumno("Pato", 5));
        al.add(new Alumno("Diego", 6));
        al.add(new Alumno("Sonia", 4));
        al.add(2, new Alumno("Tiago", 7));
        al.set(3, new Alumno("Vale", 2));


        System.out.println(al);
        System.out.println("size = " + al.size());

        //elimina por la llave que se genere en el equals
        //removiendo por instancia, utiliza el metodo equals.
        al.remove(new Alumno("Tiago", 7));
        System.out.println(al);
        System.out.println("size = " + al.size());

        /*removiendo por indice
            al.remove(0);
            System.out.println(al);
            System.out.println("size = " + al.size());
         */


        //Contains
        //El contains, tambien busca por la llave en el equals.
        System.out.println("\n");

        boolean boleanBusqueda1 = al.contains(new Alumno("Vale", 2));
        boolean boleanBusqueda2 = al.contains(new Alumno("Diego", 2));
        System.out.println("==========================================");
        System.out.println("La lista contiene a Vale = " + boleanBusqueda1);
        System.out.println("La lista contiene a Diego = " + boleanBusqueda2);
        System.out.println("==========================================");
        System.out.println("\n");


        //se genera un arreglo , y se llena con los datos en una nueva lista.
        Object a[] = al.toArray();
        for (int i = 0; i < a.length ; i++) {
            System.out.println("Desde el arreglo = " + a[i]);
        }
    }
}
