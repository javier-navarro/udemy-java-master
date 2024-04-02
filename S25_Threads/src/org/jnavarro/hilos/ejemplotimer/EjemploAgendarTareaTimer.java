package org.jnavarro.hilos.ejemplotimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaTimer {
    public static void main(String[] args) {

        //timer nos permite agregar tareas y programarlas
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("tarea realizada en: "+new Date() + "nombre del Thread: "
                + Thread.currentThread().getName());
                System.out.println("Finaliza el tiempo");
                timer.cancel();
            }
        }, 5000); //metodo para agregar tareas
        System.out.println("Agendamos una tarea para 5 minutos mas...");
    }
}
