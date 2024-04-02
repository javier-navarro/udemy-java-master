package org.jnavarro.hilos.ejemploexecutor;

import org.jnavarro.hilos.ejemplosync.Panaderia;
import org.jnavarro.hilos.ejemplosync.runnable.Consumidor;
import org.jnavarro.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamaño del pool: "+ executorService.getPoolSize());
        System.out.println("Cantidad de tareas en cola: "+executorService.getQueue().size());

        Panaderia panaderia = new Panaderia();
        Runnable productor = new Panadero(panaderia);
        Runnable consumidor = new Consumidor(panaderia);

        Future<?> futuro1 = executorService.submit(productor);
        Future<?> futuro2 = executorService.submit(consumidor);

        System.out.println("Tamaño del pool: "+ executorService.getPoolSize());
        System.out.println("Cantidad de tareas en cola: "+executorService.getQueue().size());
        executorService.shutdown();
    }
}
