package org.jnavarro.datetime.ejemplos;

import java.time.LocalDate;
import java.time.Period;

//son inmutables las fechas.
public class EjemploPeriodo {
    public static void main(String[] args) {
        LocalDate fecha1 = LocalDate.of(2011,9,23);
        LocalDate fecha2 = LocalDate.of(2020,11,25);

        LocalDate fecha3 = fecha2.withMonth(12);
        System.out.println("fecha3 = " + fecha3);
        
        Period periodo = Period.between(fecha1,fecha2);
        System.out.println("periodo = " + periodo);

        System.out.printf("Periodo entre %s y %s hay %d años, %d meses y %d dias" ,
                fecha1,fecha2,periodo.getYears(),periodo.getMonths(),periodo.getDays());
    }
}
