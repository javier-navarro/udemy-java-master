package Seccion12_Arreglos;

import java.util.Scanner;

/*
* Sistema estadistico de un arreglo
* Leer 7 números por teclado para llenar un arreglo y a
*  continuación calcular el promedio de los números positivos,
*  el promedio de los negativos y contar el número de ceros.
* */
public class Tarea15  {
    public static void main(String[] args) {

        double[] numeros = new double[7];
        Scanner scanner = new Scanner(System.in);
        int contadorPositivos = 0;
        int contadorNegativos = 0;
        int contadorCeros = 0;

        double promedioPositivos = 0;
        double promedioNegativos = 0;

        System.out.println("Ingresa 7 numeros");

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = scanner.nextInt();
        }

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == 0) {
                contadorCeros++;
            }
            else if( numeros[i] > 0){
                contadorPositivos++;
                promedioPositivos += numeros[i];
            }else {
                contadorNegativos++;
                promedioNegativos += numeros[i];
            }
        }
        if( promedioPositivos > 0){
            System.out.println("promedioPositivos = " + (promedioPositivos)/contadorPositivos);
        }else {
            System.out.println("promedioPositivos = " + 0);
        }
        System.out.println("contadorCeros = " + contadorCeros);
        if( promedioNegativos < 0) {
            System.out.println("promedioNegativos = " + (promedioNegativos) / contadorNegativos);
        }else{
            System.out.println("promedioNegativos = " + 0);
        }

    }
}
