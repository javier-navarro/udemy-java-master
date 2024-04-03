package org.jnavarro.tarea29;

import java.util.Arrays;

public class Tarea30 {
    public static void main(String[] args) {
        String variable1 = "hola como estan hola";

        System.out.println("contador palabras: "+contadorPalabras(variable1));
    }

    static int contadorPalabras(String palabra){
        System.out.println("=========================================");
        int palabraRepetida = palabra.split("\\s+|\n|,").length;
        String [] sentences = palabra.split("\\.|,");
        System.out.println(Arrays.toString(sentences));
        return palabraRepetida;
    }
}
