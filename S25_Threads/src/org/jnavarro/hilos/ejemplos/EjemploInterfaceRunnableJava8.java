package org.jnavarro.hilos.ejemplos;

public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread();
        //Thread.currentThread().getName() sirve para saber el nombre del hilo
        Runnable viaje = () -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Finalmente me voy de viaja a: "+ Thread.currentThread().getName());
                System.out.println(main.getState());
            };

        Thread v1 = new Thread(viaje,"Cancun");
        Thread v2 = new Thread(viaje,"Talagante");
        Thread v3 = new Thread(viaje,"Paris");
        v1.start();
        v2.start();
        v3.start();
        v1.join(); // join espera que los demas hilos terminen
        v2.join();
        v3.join();
        //Thread.sleep(10000); //es una pausa del main
        // join espera que los demas hilos terminen
        System.out.println("Continuando en el main.. "+ main.getName());
    }
}
