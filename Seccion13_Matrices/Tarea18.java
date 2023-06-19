package Seccion13_Matrices;

import java.util.Scanner;

public class Tarea18 {
    public static void main(String[] args) {
        String [][] matriz;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa cantidad de veces a repetir");
        try {
            int respuesta = scanner.nextInt();
            matriz = new String[respuesta][respuesta];

            if(respuesta == 0){
                System.out.println("ERROR");
                System.exit(1);
            }

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    if( i == 0 && j == 0 || i == j || matriz[i].length-1 == j-i || matriz.length-i == j+1 ){
                        matriz[i][j] = "X";
                    }else{
                        matriz[i][j] = "_";
                    }
                }
                System.out.println();
            }

            //para inmprimir
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j]+ "\t");
                }
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
