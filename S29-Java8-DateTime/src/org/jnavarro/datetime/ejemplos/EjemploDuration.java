package org.jnavarro.datetime.ejemplos;

import java.time.Duration;
import java.time.LocalDateTime;

public class EjemploDuration {
    public static void main(String[] args) {
        LocalDateTime fecha1 = LocalDateTime.now();
        LocalDateTime fecha2 = LocalDateTime.now().plusHours(3).plusMinutes(20).plusDays(1);
        Duration lapsus = Duration.between(fecha1,fecha2);
        System.out.println("lapsus = " + lapsus);
        System.out.println("lapsus.toSeconds() = " + lapsus.toSeconds());
        System.out.println("lapsus.toMinutes() = " + lapsus.toMinutes());
        System.out.println("lapsus.toHours() = " + lapsus.toHours());
        System.out.println("lapsus.plusHours(5) = " + lapsus.plusHours(5));
    }
}
