package org.jnavarro.hilos.ejemplotimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {


        //timer nos permite agregar tareas y programarlas
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            //private int contador =3;
            AtomicInteger contador = new AtomicInteger(3);
            @Override
            public void run() {
                int i = contador.getAndDecrement();
                if ( i>0) {
                    System.out.println("tarea "+i+  " periodica en: "+new Date() + "nombre del Thread: "
                            + Thread.currentThread().getName());
                }else{
                    System.out.println("Finaliza el tiempo");
                    timer.cancel();
                }
            }
        }, 5000, 7000); //metodo para agregar tareas
        System.out.println("Agendamos una tarea para 5 minutos mas...");
    }
}
