package Seccion12_Arreglos;

import java.util.Scanner;
// Clase 105 - Obtener el numero mayor de un arreglo de enteros
public class EjemploArreglosNumeroMayor {
    public static void main(String[] args) {
        int arregloEnteros[] = new int[5];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < arregloEnteros.length; i++) {
            System.out.println("agrega 5 numeros");
            arregloEnteros[i] = scanner.nextInt();
        }

        int max = 0;
        for (int i = 1; i <arregloEnteros.length ; i++) {
            max = (arregloEnteros[max] > arregloEnteros[i]) ? max : i;
        }
        System.out.println("arregloEnteros[max] = " + arregloEnteros[max]);
    }
}
