package org.jnavarro.datetime.ejemplos;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class EjemploZonedDateTime {
    public static void main(String[] args) {
        LocalDateTime fechaLocal = LocalDateTime.parse("2021-09-23T12:45");
        ZoneId newYork = ZoneId.of("America/New_York");
        //ZonedDateTime zonaNewYork =  ZonedDateTime.of(fechaLocal,newYork);
        //ZonedDateTime zonaNewYork =  ZonedDateTime.of(fechaLocal, ZoneOffset.of("-04:00"));
        ZonedDateTime zonaNewYork =  fechaLocal.atZone(newYork);

        System.out.println("zonaNewYork = " + zonaNewYork);
        
        ZoneId madrid = ZoneId.of("Europe/Madrid");
        ZonedDateTime zonaMadrid = zonaNewYork.withZoneSameInstant(madrid).plusHours(8);
        System.out.println("zonaMadrid = " + zonaMadrid);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm, dd MMM yyyy");
        System.out.println("detalles del viaje a españa");
        System.out.println("partida en NY = " + f.format(zonaNewYork));
        System.out.println("Llegada a madrid = " + f.format(zonaMadrid));

        Set zonas = ZoneId.getAvailableZoneIds();
        zonas.forEach(System.out::println);
    }
}
