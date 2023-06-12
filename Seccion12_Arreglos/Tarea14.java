package Seccion12_Arreglos;

import java.util.Scanner;

/*
* Escriba un programa que imprima el número más alto de un arreglo de 7 elementos (de rango 11 a 99), por ejemplo {14, 33, 15, 36, 78, 21, 43}, si se repite un valor considerar uno solo.
* */
public class Tarea14 {

    public static void main(String[] args) {
        int[] numeros = new int[7];
        Scanner scanner = new Scanner(System.in);
        int numeroMayor = 0;

        System.out.println("Ingresa 7 numeros");

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = scanner.nextInt();
        }

        for (int i = 0; i < numeros.length -1; i++) {
            
            if(numeros[i] > numeros[i+1]){
                numeroMayor = numeros[i];
            }else {
                numeroMayor = numeros[i+1];
            }
        }
        System.out.println("numeroMayor = " + numeroMayor);
    }
}
