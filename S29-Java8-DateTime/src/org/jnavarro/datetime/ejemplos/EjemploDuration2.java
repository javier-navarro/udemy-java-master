package org.jnavarro.datetime.ejemplos;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class EjemploDuration2 {
    public static void main(String[] args) {
        Instant uno = Instant.now();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Instant dos = Instant.now();
        Duration tiempo = Duration.between(uno,dos);
        System.out.println("tiempo = " + tiempo);
    }
}
