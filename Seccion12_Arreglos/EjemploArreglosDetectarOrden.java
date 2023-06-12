package Seccion12_Arreglos;

import java.util.Scanner;
//Clase 106 - Detectar orden del arreglo
public class EjemploArreglosDetectarOrden {
    public static void main(String[] args) {
        int[] arreglo = new int[5];

        Scanner scanner = new Scanner(System.in);
        System.out.println("ingresa 5 numeros");
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = scanner.nextInt();
        }

        boolean ascendente = false;
        boolean descendente = false;

        for (int i = 0; i < arreglo.length -1; i++) {
            if(arreglo[i] > arreglo[i+1]){
                descendente = true;
            }
            if(arreglo[i] < arreglo[i+1]){
                ascendente = true;
            }
        }

        if( ascendente ==true && descendente ==true){
            System.out.println("arreglo desordenado");
        }else if (ascendente == false && descendente == false){
            System.out.println("arreglo todos iguales");
        }else if (ascendente == false && descendente == true){
            System.out.println("arreglo ordenado forma descendente");
        }else if (ascendente == true && descendente == false){
            System.out.println("arreglo ordenado forma ascendente");
        }
    }
}
