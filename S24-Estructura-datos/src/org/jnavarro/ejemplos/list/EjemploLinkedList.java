package org.jnavarro.ejemplos.list;

import org.jnavarro.ejemplos.modelo.Alumno;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class EjemploLinkedList {
    public static void main(String[] args) {
        LinkedList<Alumno> enlazada = new LinkedList<>();
        System.out.println(enlazada + ", size = " + enlazada.size());
        System.out.println("esta vacia = " + enlazada.isEmpty());
        enlazada.add(new Alumno("Pato", 5));
        enlazada.add(new Alumno("Diego", 6));
        enlazada.add(new Alumno("Sonia", 4));
        enlazada.add( new Alumno("Tiago", 7));
        enlazada.add(new Alumno("Vale", 2));


        System.out.println(enlazada);
        System.out.println("size = " + enlazada.size());

        //agregamos al principio y al final con metodos propios de linkedlist
        System.out.println("===================================================================================");
        System.out.println("agregamos al principio y al final con metodos propios de linkedlist");

        enlazada.addFirst(new Alumno("Zeus", 5));
        enlazada.addLast(new Alumno("Atenea", 6));
        System.out.println(enlazada);
        System.out.println("size = " + enlazada.size());
        //System.out.println("\n");

        //buscamos los valores del principio y final con metodos propios de linkedlist
        /*
            getFirst() -> si no encuentra nada o lista vacia devuelve exception
            peek() ->
            peekFirst() ->
            peekLast() -> si no encuentra nada no manda exception , devuelve null si no encuentra nada
         */
        System.out.println("===================================================================================");
        System.out.println("buscamos los valores del principio y final con metodos propios de linkedlist");
        System.out.println("primero = " + enlazada.getFirst());
        System.out.println("ultimo = " + enlazada.getLast());
        System.out.println("indice 2 = " + enlazada.get(2));

        //removemos con metodos propios de la clase
        /*
            removeFirst() -> remueve el primero, lanza exception
            removeLast() -> remueve el ultimo, lanza exception
            poolFirst -> remueve el primero, retorna null en caso de vacio
            poolLast ->  remueve el primero, retorna null en caso de vacio
            pop -> elimina y retorna el primero de la lista , exception
         */
        System.out.println("===================================================================================");
        System.out.println("remove");

        Alumno Zeus = enlazada.removeFirst(); // lanza ex
        enlazada.removeLast();

        System.out.println("===================================================================================");
        System.out.println("agregar");

        Alumno alumno1 = new Alumno("Lucas", 5);
        enlazada.addLast(alumno1);
        System.out.println("Indice de Lucas = " + enlazada.indexOf(alumno1));

        System.out.println("===================================================================================");
        System.out.println("set");

        //modifica la posicion
        enlazada.set(3, new Alumno("Dzeko",9));
        System.out.println(enlazada +", SIZE = " + enlazada.size());

        //ListIterator
        System.out.println("===================================================================================");
        System.out.println("ListIterator");

        ListIterator<Alumno> li = enlazada.listIterator();
        while (li.hasNext()){
            System.out.println(li.next());
        }

        System.out.println("===================================================================================");
        System.out.println("al revez");
        while (li.hasPrevious()){
            Alumno alumno = li.previous();
            System.out.println(alumno);
        }

    }
}
