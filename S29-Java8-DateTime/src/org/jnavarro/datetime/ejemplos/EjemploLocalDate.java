package org.jnavarro.datetime.ejemplos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class EjemploLocalDate {
    public static void main(String[] args) {

        LocalDate fechaActual = LocalDate.now();
        System.out.println("fechaActual = " + fechaActual);
        System.out.println("Dia: " + fechaActual.getDayOfMonth());

        Month mes = fechaActual.getMonth();

        System.out.println("Mes: " + mes);
        System.out.println("numero del mes: "+mes.getValue());
        System.out.println("mes en español: "+mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));

        DayOfWeek diaSemana = fechaActual.getDayOfWeek();
        System.out.println("numero del dia = " + diaSemana.getValue());
        System.out.println("nombre del dia = " + diaSemana.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
        
        System.out.println("Año: " + fechaActual.getYear());
        System.out.println("Dia del año: " + fechaActual.getDayOfYear());
        System.out.println("Era: " + fechaActual.getEra());

        fechaActual = LocalDate.of(2020,1,30);
        System.out.println("fechaActual2 = " + fechaActual);

        fechaActual = LocalDate.of(2020, Month.DECEMBER,30);
        System.out.println("fechaActual3 = " + fechaActual);

        fechaActual = LocalDate.parse("2022-10-10");
        System.out.println("fechaActual4 = " + fechaActual);
        
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println("tomorrow = " + tomorrow);
        
        LocalDate mesAnteriorMismoDia = LocalDate.now().minusMonths(1);
        System.out.println("mesAnteriorMismoDia = " + mesAnteriorMismoDia);

        DayOfWeek miercoles = LocalDate.parse("2020-11-11").getDayOfWeek();
        System.out.println("miercoles = " + miercoles);

        int once = LocalDate.of(2020,11,11).getDayOfMonth();
        System.out.println("once = " + once);

        boolean esBisiesto = LocalDate.now().isLeapYear();
        System.out.println("esBisiesto = " + esBisiesto);

        boolean esAntes = LocalDate.of(2020,11,11).isBefore(LocalDate.parse("2020-11-10"));
        System.out.println("esAntes = " + esAntes);

        boolean esDespues = LocalDate.parse("2020-11-11").isAfter(LocalDate.parse("2020-11-10"));
        System.out.println("esDespues = " + esDespues);


    }
}
