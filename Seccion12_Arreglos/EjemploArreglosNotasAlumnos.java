package Seccion12_Arreglos;

import java.util.Scanner;

//Clase 108 - Sistema de notas
public class EjemploArreglosNotasAlumnos {
    public static void main(String[] args) {

        double[] claseMatematicas, claseHistoria, claseLenguaje;
        double sumaMatematicas = 0;
        double sumaHistoria = 0;
        double sumaLenguaje = 0;
        claseMatematicas = new double[7];
        claseHistoria = new double[7];
        claseLenguaje = new double[7];

        Scanner scanner = new Scanner(System.in);

        System.out.println("ingresa 7 notas para matematicas");
        for (int i = 0; i < claseMatematicas.length; i++) {
            claseMatematicas[i] = scanner.nextDouble();
        }

        System.out.println("ingresa 7 notas para Historia");
        for (int i = 0; i < claseHistoria.length; i++) {
            claseHistoria[i] = scanner.nextDouble();
        }

        System.out.println("ingresa 7 notas para Lenguaje");
        for (int i = 0; i < claseLenguaje.length; i++) {
            claseLenguaje[i] = scanner.nextDouble();
        }

        for (int i = 0; i < 7; i++) {
            sumaMatematicas += claseMatematicas[i];
            sumaHistoria += claseHistoria[i];
            sumaLenguaje += claseLenguaje[i];
        }

        double promMatematicas = (sumaMatematicas/claseMatematicas.length);
        double promHistoria = (sumaHistoria/claseHistoria.length);
        double promLenguaje = (sumaLenguaje/claseLenguaje.length);


        System.out.println("promMatematicas = " + promMatematicas);
        System.out.println("promHistoria = " + promHistoria);
        System.out.println("promLenguaje = " + promLenguaje);
        System.out.println("promedio total: "+ (promMatematicas+promHistoria+promLenguaje)/3);

        System.out.println("ingresa identificador del alumno (0 - 6)");
        int id = scanner.nextInt();
        double promedioAlumno = (claseHistoria[id] + claseLenguaje[id] + claseMatematicas[id])/3;
        System.out.println("promedioAlumno = "+id + " : " + promedioAlumno);
    }
}
