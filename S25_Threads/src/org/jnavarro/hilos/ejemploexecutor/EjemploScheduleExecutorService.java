package org.jnavarro.hilos.ejemploexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
*   Tareas que se ejecutan de forma periodica
*
*   metodos ->
*       schedule: puede devolver calleable o runnable.
* */
public class EjemploScheduleExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        System.out.println("Alguna tarea en el main....");
        executor.schedule(() ->{
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hola mundo tarea....");
        },0, TimeUnit.MILLISECONDS);

        System.out.println("Alguna otra tarea en el main....");
        executor.shutdown();
    }
}
