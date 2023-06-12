package Seccion12_Arreglos;

import java.util.Scanner;

//Clase 111 - Agregar elemento en determinada posicion y desplazar el resto de elementos.
public class EjemploArreglosDesplazarPosicion2 {
    public static void main(String[] args) {
        int[] a = new int[10];
        int elemento, posicion;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < a.length-1; i++) {
            System.out.print("Ingresa el numero: ");
            a[i] = scanner.nextInt();
        }

        System.out.println("ingresa nuevo elemento");
        elemento = scanner.nextInt();;

        System.out.println("ingresa posicion");
        posicion = scanner.nextInt();


        for (int i = a.length -2; i >= posicion ; i--) {
            a[i+1] = a[i];
        }
        a[posicion] = elemento;

        System.out.println("arreglo: ");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);

        }

    }
}
