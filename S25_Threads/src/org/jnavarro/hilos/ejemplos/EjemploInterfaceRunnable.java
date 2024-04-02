package org.jnavarro.hilos.ejemplos;

import org.jnavarro.hilos.ejemplos.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) {

        new Thread(new ViajeTarea("Cancun")).start();
        new Thread(new ViajeTarea("Talagante")).start();
        new Thread(new ViajeTarea("Paris")).start();
    }
}
