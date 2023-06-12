package Seccion12_Arreglos;

import java.util.Scanner;

/*
* Leer 10 números enteros desde el teclado para llenar un arreglo de 10
* elementos. Luego debemos mostrarlos en el siguiente orden: el último,
*  el primero, el penúltimo, el segundo, el antepenúltimo, el tercero, y
* así sucesivamente.
* */
public class Tarea13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arreglo = new int[10];

        System.out.println("Ingresa 10 elementos");
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = scanner.nextInt();
        }

        for (int i = 0; i < arreglo.length - i; i++) {
            System.out.print(arreglo[arreglo.length - 1 - i] + " ");
            System.out.println(arreglo[i]);
        }

    }
}
