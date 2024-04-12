package org.jnavarro.datetime.ejemplos;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class EjemploLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime fechaTiempo = LocalDateTime.now();
        System.out.println("fechaTiempo1 = " + fechaTiempo);
        
        fechaTiempo = LocalDateTime.of(2020, Month.DECEMBER,24,20,45,59);
        System.out.println("fechaTiempo2 = " + fechaTiempo);
        
        fechaTiempo = LocalDateTime.parse("2019-07-23T00:00:00");
        System.out.println("fechaTiempo3 = " + fechaTiempo);

        fechaTiempo = fechaTiempo.plusDays(1).plusHours(2);
        System.out.println("fechaTiempo4 = " + fechaTiempo);

        System.out.println("fechaTiempo.minusHours(5) = " + fechaTiempo.minusHours(5));
        
        Month mes = fechaTiempo.getMonth();
        System.out.println("mes = " + mes);
        
        int dia = fechaTiempo.getDayOfMonth();
        System.out.println("dia = " + dia);
        
        int anio = fechaTiempo.getYear();
        System.out.println("anio = " + anio);
        
        String formato1 = fechaTiempo.format(DateTimeFormatter.ISO_DATE);
        System.out.println("formato1 = " + formato1);

        String formatoPersonalizado = fechaTiempo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss a"));
        System.out.println("formatoPersonalizado = " + formatoPersonalizado);
    }
}
