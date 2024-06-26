package org.jnavarro.datetime.ejemplos;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EjemploLocalTime {
    public static void main(String[] args) {

        LocalTime ahora = LocalTime.now();
        System.out.println("ahora = " + ahora);
        System.out.println("horas = " + ahora.getHour());
        System.out.println("minutos = " + ahora.getMinute());
        System.out.println("segundos = " + ahora.getSecond());
        
        LocalTime seisConTreinta = LocalTime.of(6,30);
        System.out.println("seisConTreinta = " + seisConTreinta);
        seisConTreinta = LocalTime.parse("06:30");
        System.out.println("seisConTreinta = " + seisConTreinta);

        LocalTime sieteConTreinta = LocalTime.of(6,30).plus(1, ChronoUnit.HOURS);
        System.out.println("sieteConTreinta = " + sieteConTreinta);

        boolean esAnterior = LocalTime.of(6,30).isBefore(LocalTime.parse("07:30"));
        System.out.println("esAnterior = " + esAnterior);
        
        //datetimeformatter para la hora
        // hh: hora am -pm , HH : horario 24horas

        DateTimeFormatter  dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String ahoraFormateado = seisConTreinta.format(dateTimeFormatter);
        System.out.println("ahoraFormateado = " + ahoraFormateado);

        ahoraFormateado = dateTimeFormatter.format(ahora);
        System.out.println("ahoraFormateado = " + ahoraFormateado);

        LocalTime max =  LocalTime.MAX;
        LocalTime min =  LocalTime.MIN;
        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }
}
