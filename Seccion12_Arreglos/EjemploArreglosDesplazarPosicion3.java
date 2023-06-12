package Seccion12_Arreglos;

import java.util.Scanner;

//Clase 112 Agregar elemento en posicion adecuada y reordenar.
public class EjemploArreglosDesplazarPosicion3 {
    public static void main(String[] args) {
        int[] arreglo = new int[7];
        int numero , posicion = 0;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < arreglo.length -1; i++) {
            System.out.println("Ingresa numero: ");
            arreglo[i] = scanner.nextInt();
        }
        System.out.println();
        System.out.println("ingresa numero a insertar: ");
        numero = scanner.nextInt();

        while(posicion < 6 && numero > arreglo[posicion]){
            posicion++;
        }

        for (int i = arreglo.length -2;  i >= posicion; i--) {
            arreglo[i + 1] = arreglo[i];
        }

        arreglo[posicion] = numero;
        System.out.println("nuevo arreglo ordenado: ");

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }

    }
}
