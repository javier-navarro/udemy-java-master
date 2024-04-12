package org.jnavarro.tarea;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/*
Para esta tarea se pide ingresar una fecha de nacimiento en formato string,
convertirla a una fecha del tipo LocalDate y calcular la edad de la persona de acuerdo a la fecha actual.
 */
public class Tarea35 {
    public static void main(String[] args) {
        String fechaNacimiento;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa fecha de nacimiento");
        fechaNacimiento = scanner.next();
        System.out.println("fechaNacimiento = " + fechaNacimiento);

        LocalDate fechaActual = LocalDate.now();
        System.out.println(fechaActual);
        
        LocalDate fechaFormateada = LocalDate.parse(fechaNacimiento);
        System.out.println("fechaFormateada = " + fechaFormateada);

        Period diferencia = Period.between(fechaFormateada,fechaActual);
        System.out.println("Edad = " + diferencia.getYears());
        

    }
}
