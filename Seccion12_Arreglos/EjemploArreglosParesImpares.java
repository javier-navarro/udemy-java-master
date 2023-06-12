package Seccion12_Arreglos;

import java.util.Scanner;
//Clase 107 - Copiar pares e impares
public class EjemploArreglosParesImpares {
    public static void main(String[] args) {
        int[] arreglo, pares , impares;
        int totalImpares = 0 , totalPares = 0;
        arreglo = new int[10];

        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese 10 numeros");
        for (int i = 0; i < arreglo.length ; i++) {
            arreglo[i] = scanner.nextInt();
        }

        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i]%2 == 0){
                totalPares++;
            }else {
                totalImpares++;
            }
        }
        pares = new int[totalPares];
        impares = new int[totalImpares];

        int auxiliarPares = 0;
        int auxiliarImpares = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i]%2 == 0){
                pares[auxiliarPares++] = arreglo[i];
            }else {
                impares[auxiliarImpares++] = arreglo[i];
            }
        }

        System.out.println("=====pares======");
        for (int i = 0; i < pares.length; i++) {
            System.out.println("pares[i] = " + pares[i]);
        }

        System.out.println("=====impares======");
        for (int i = 0; i < impares.length; i++) {
            System.out.println("impares[i] = " + impares[i]);
        }
    }
}
