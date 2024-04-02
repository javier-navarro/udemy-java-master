package org.jnavarro.hilos.ejemploexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException {

        /*
        * shutdown() -> apaga despues de que se ejecuto todo
        * shutdownnow -> apaga todo de forma abrupta.
        * awaitTermination -> tambien espera que terminen las tareas., termina bien o da timeout
        * */
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Runnable tarea = () -> {
            System.out.println("inicio de la tarea");
            try {
                System.out.println("Nombre del thread "+Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                //en caso de error interrumpe la tarea.
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea");
        };
        executorService.submit(tarea); //envia la tarea
        executorService.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main 1");
        executorService.awaitTermination(2,TimeUnit.SECONDS);
        System.out.println("Continuando con la ejecucion del metodo main 2");
    }
}
