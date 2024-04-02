package org.jnavarro.hilos.ejemplos;

import org.jnavarro.hilos.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {

        Thread hilo = new NombreThread("Javier Ackerman");
        hilo.start();
        Thread hilo2 = new NombreThread("Dzeko");
        hilo2.start();

        NombreThread hilo3 = new NombreThread("Ragnar");
        hilo3.start();
        //Thread.sleep(100); varia y modifica el estado
        System.out.println(hilo.getState());
    }
}
