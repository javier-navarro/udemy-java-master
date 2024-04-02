package org.jnavarro.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        /*
        * shutdown() -> apaga despues de que se ejecuto todo
        * shutdownnow -> apaga todo de forma abrupta.
        * awaitTermination -> tambien espera que terminen las tareas., termina bien o da timeout
        * */
        //ExecutorService executorService = Executors.newSingleThreadExecutor(); //maneja solo un hilo
        ExecutorService executorService = Executors.newFixedThreadPool(3); //va adaptandose a la demanda

        Callable<String> tarea = () -> {
            System.out.println("inicio de la tarea");
            try {
                System.out.println("Nombre del thread "+Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                //en caso de error interrumpe la tarea.
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea");
            return "algun resultado...";
        };
        /*

        metodo submit permite runnable o callable
             //Future
             declaracion :
              Future<?> resultado = executorService.submit(tarea);
            runnable, no devuelve nada
            calleable , devuelve valores.
            get --> bloquea el thread actual. podria producir un error para tareas muy largas, por lo que se puede definir con tiempo
                resultado.get(5, TimeUnit.SECONDS)
         */

        Callable<Integer> tarea2 = () -> {
            System.out.println("Iniciando Tarea2");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };

        Future<String> resultado = executorService.submit(tarea); //envia la tarea
        Future<String> resultado2 = executorService.submit(tarea);
        Future<Integer> resultado3 = executorService.submit(tarea2);
        executorService.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main");

        while(!(resultado.isDone() && resultado2.isDone() && resultado3.isDone())){
            System.out.println("======================================================");
            System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3: %s",
                    resultado.isDone()? "finalizado" : "en proceso",
                    resultado2.isDone()? "finalizado" : "en proceso",
                    resultado3.isDone()? "finalizado" : "en proceso"));
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        //System.out.println(resultado.get()); // no devuelve nada
        System.out.println("Obtenemos resultado1 de la tarea" +resultado.get());
        System.out.println("Finaliza la tarea1: "+ resultado.isDone());

        System.out.println("Obtenemos resultado2 de la tarea" +resultado2.get());
        System.out.println("Finaliza la tarea2: "+ resultado2.isDone());

        System.out.println("Obtenemos resultado3 de la tarea" +resultado3.get());
        System.out.println("Finaliza la tarea3: "+ resultado3.isDone());

    }
}
