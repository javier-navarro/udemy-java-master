package org.jnavarro.hilos.ejemploexecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/*
*   Tareas que se ejecutan de forma periodica
*
*   metodos ->
*       schedule: puede devolver calleable o runnable.
*       scheduleAtFixedRate: tasa fija de tiempo entre tareas, es flexible se acopla
*       scheduleWithFixedDelay: delay fijo entre tareas, el delay es entre las tareas
*
*       Para que funcione scheduleWithFixedDelay o scheduleAtFixedRate, se debe generar una pausa para que se apague
*       cuando terminen todas las tareas-
*       1- con Timeunit -> TimeUnit.SECONDS.sleep(10);
 * */
public class EjemploScheduleExecutorServicePeriodo {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        System.out.println("Alguna tarea en el main....");

        //CountDownLatch look = new CountDownLatch(5); //bloquea hasta que se termine la ejecucion
        AtomicInteger contador = new AtomicInteger(5); // otra opcion
        Future<?> future = executor.scheduleWithFixedDelay(() ->{
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                //look.countDown();
                contador.getAndDecrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hola mundo tarea....");
        },1000,2000, TimeUnit.MILLISECONDS);

        // TimeUnit.SECONDS.sleep(10);
        //look.await(); //bloquea hasta que se terminen las tareas
        //future.cancel(true); //apaga de inmediato con true, con false espera que terminen las tareas
        while(contador.get() >0){
            if(contador.get() == 0){
                future.cancel(true);
                contador.getAndDecrement();
            }
        }
        System.out.println("Alguna otra tarea en el main....");
        executor.shutdown();
    }
}
