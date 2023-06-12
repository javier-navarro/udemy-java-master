package Seccion12_Arreglos;

//Clase 102 - Imprimiendo i-nesimo numero
public class EjemploArreglosOrdenamientoPrincipioFin {
    public static void main(String[] args) {

        int numeros[] = new int[10];
        int numerosOrdenados[] = new int[10];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 1;
        }
        //opcion1
        System.out.println("======opcion1=======");
        for (int i = 0; i < numeros.length / 2; i++) {
            System.out.println(numeros[i]);
            System.out.println(numeros[numeros.length - 1 - i]);
        }

        //opcion2
        System.out.println("======opcion2=======");
        for (int i = 0; i < numeros.length - i; i++) {
            System.out.print(numeros[i] + " ");
            System.out.println(numeros[numeros.length - 1 - i]);
        }
        //llenado de arreglo nuevo
        int aux = 0;
        for (int i = 0; i < numeros.length-i; i++) {
            numerosOrdenados[aux++] = numeros[i];
            numerosOrdenados[aux++] = numeros[numeros.length -1 -i];
        }
        
        for (int i = 0; i < numerosOrdenados.length; i++) {
            System.out.println("numerosOrdenados = " + numerosOrdenados[i]);
        }

    }

}
