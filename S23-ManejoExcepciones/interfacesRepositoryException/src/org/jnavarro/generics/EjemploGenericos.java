package org.jnavarro.generics;

import org.jnavarro.poointerfaces.modelo.Cliente;
import org.jnavarro.poointerfaces.modelo.ClientePremiun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EjemploGenericos {

    public static void main(String[] args) {
        List clientes  = new ArrayList();
        clientes.add(new Cliente("karim", "Benzema"));
        //Cliente javier = (Cliente)clientes.get(0);
        Cliente javier = (Cliente)clientes.iterator().next();

        Cliente[] clientesArreglo = {
                new Cliente("Andry", "Shevchenko"),
                new Cliente("romelu", "Lukaku")
        };

        Integer[] enterosArreglo = {1,2,3};

        List<Cliente> clientesLista = fromArrayToList(clientesArreglo);
        List<Integer> enterosLista = fromArrayToList(enterosArreglo);
        clientesLista.forEach(System.out::println);
        enterosLista.forEach(System.out::println);

        List<String> nombres = fromArrayToList(new String[] { "andres", "madison", "tanjiro", "goku"},  enterosArreglo);
        nombres.forEach(System.out::println);

        List<ClientePremiun> clientePremiuns = fromArrayToList(
                new ClientePremiun[]{
                        new ClientePremiun("Kevin","KDB17")});

        imprimirClientes(clientes);
        imprimirClientes(clientesLista);
        imprimirClientes(clientePremiuns);

        System.out.println("Máximo de enteros 1,9,4 es: "+maximo(1,9,4));
        System.out.println(maximo(3.9,11.6,7.78));
        System.out.println(maximo("arandano","zanahoria", "manzana"));

    }

    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T extends Number> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T extends Cliente > List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T,G> List<T> fromArrayToList(T[] c, G[] g){
        for (G elemento: g){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    public static void imprimirClientes(List< ?extends Cliente> clientes) {
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c){
        T  max = a;
        if(b.compareTo(max) > 0){
            max = b;
        }
        if(c.compareTo(max) > 0){
            max = c;
        }
        return max;
    }
}
