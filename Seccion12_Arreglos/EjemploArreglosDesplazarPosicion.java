package Seccion12_Arreglos;

import java.util.Scanner;

//Clase 110 - Desplazar elementos de un array
public class EjemploArreglosDesplazarPosicion {
    public static void main(String[] args) {
        int[] a = new int[5];
        int ultimo;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < a.length; i++) {
            System.out.print("Ingresa el numero: ");
            a[i] = scanner.nextInt();
        }

        ultimo = a[a.length - 1];
        for (int i = a.length -2; i >=0 ; i--) {
            a[i+1] = a[i];
        }
        a[0] = ultimo;

        System.out.println("arreglo: ");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);

        }

    }
}
