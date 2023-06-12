package Seccion12_Arreglos;

import java.util.Scanner;
//clase 109 - buscar elemento en arreglo.
public class EjemploArreglosBuscarNumero {
    public static void main(String[] args) {
        int[] arregloNumeros = new int[5];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < arregloNumeros.length; i++) {
            System.out.println("Ingresa numero: ");
            arregloNumeros[i] = scanner.nextInt();
        }

        System.out.println("\nIngresa numero a buscar");
        int numero = scanner.nextInt();
        int i = 0;

        while(i < arregloNumeros.length && arregloNumeros[i] != numero){
            i++;
        }

        if( i == arregloNumeros.length){
            System.out.println("numero desconocido");
        }else if (arregloNumeros[i] == numero){
            System.out.println("Encontrado en la posicion = " + i);
        }
    }
}
