package org.jnavarro.patrones.observer.ejemplos;

import org.jnavarro.patrones.observer.Corporacion;

public class EjemploObserver {
    public static void main(String[] args) {
        Corporacion google = new Corporacion("Google", 1000);
        google.addObserver((observable, obj) -> {
            System.out.println("Eren: " + observable);
        });

        google.addObserver((observable,obj) -> {
            System.out.println("Mikasa: " + ((Corporacion)observable).getNombre() +
                    "nuevo precio $" +
                    ((Corporacion)observable).getPrecio());
        });

        google.addObserver((observable,obj) -> {
            System.out.println("Armin: " + ((Corporacion)observable).getNombre() +
                    "nuevo precio $" +
                    ((Corporacion)observable).getPrecio());
        });
        google.modificarPrecio(5000);
    }
}
