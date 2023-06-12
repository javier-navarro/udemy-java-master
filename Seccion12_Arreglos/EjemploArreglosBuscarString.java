package Seccion12_Arreglos;

import java.util.Scanner;

public class EjemploArreglosBuscarString {
    public static void main(String[] args) {
        String[] arregloString = new String[5];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < arregloString.length; i++) {
            System.out.println("Ingresa nombre: ");
            arregloString[i] = scanner.next();
        }

        System.out.println("\nIngresa nombre a buscar");
        String nombre = scanner.next();

        int i = 0;

        for (;i < arregloString.length && !arregloString[i].equalsIgnoreCase(nombre); i++){}


        if( i == arregloString.length){
            System.out.println("numero desconocido");
        }else if (arregloString[i].toLowerCase().compareTo(nombre.toLowerCase()) == 0){
            System.out.println("Encontrado en la posicion = " + i);
        }
    }
}
