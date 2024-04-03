package org.jnavarro.tarea29;

public class Tarea29 {
    public static void main(String[] args) {

        String variable1 = "  asjk ,dkasd";
        System.out.println( "final: "+remuevePuntuaciones(variable1).toUpperCase());
    }

    static String remuevePuntuaciones (String palabra){
        return palabra.replaceAll("\\p{Punct}|\\p{Space}", "");
    }
}
