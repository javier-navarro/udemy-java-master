package Seccion12_Arreglos;

import java.util.Scanner;

// 113 - Eliminar un elemento del arreglo.
public class EjemploArreglosEliminarElemento {
    public static void main(String[] args) {
        int[] arreglo = new int[10];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("Ingresa numero: ");
            arreglo[i] = scanner.nextInt();
        }
        System.out.println();
        System.out.println("ingresa posicion a insertar: ");
        int posicion = scanner.nextInt();

        for (int i = posicion; i < arreglo.length -1; i++) {
            arreglo[i] = arreglo[i+1];
        }

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(i+" => " + arreglo[i]);
        }

        int[] arreglo2 = new int[arreglo.length-1];
        System.arraycopy(arreglo, 0, arreglo2, 0, arreglo2.length);

        System.out.println("\nnuevo arreglo : ");
        for (int i = 0; i < arreglo2.length; i++) {
            System.out.println(i + " => " + arreglo2[i]);
        }
    }
}
