package org.jnavarro.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        /*
        * shutdown() -> apaga despues de que se ejecuto todo
        * shutdownnow -> apaga todo de forma abrupta.
        * awaitTermination -> tambien espera que terminen las tareas., termina bien o da timeout
        * */
        ExecutorService executorService = Executors.newSingleThreadExecutor();

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

        Future<String> resultado = executorService.submit(tarea); //envia la tarea
        executorService.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main");

        //System.out.println(resultado.isDone());
        while(!resultado.isDone()){
            System.out.println("ejecutando tarea......");
            TimeUnit.MILLISECONDS.sleep(1500);
        }

        //System.out.println(resultado.get()); // no devuelve nada
        System.out.println(resultado.get(5,TimeUnit.SECONDS)); // no devuelve nada
        System.out.println("Finaliza la tarea: "+ resultado.isDone());

    }
}
