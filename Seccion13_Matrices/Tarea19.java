package Seccion13_Matrices;

import java.util.Scanner;

public class Tarea19 {
    public static void main(String[] args) {
        int [][] matriz2 = new int[6][6];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa cantidad de veces a repetir");
        try{
            int respuesta = scanner.nextInt();
            matriz2 = new int[respuesta][respuesta];

            if(respuesta == 0){
                System.out.println("ERROR");
                System.exit(1);
            }

            for (int i = 0; i < matriz2.length; i++) {
                for (int j = 0; j < matriz2[i].length; j++) {
                    //linea final
                    // j == matriz2.length-1
                    // j == 0  || j == matriz2.length-1 || i == matriz2.length/2
                    // ultimo j == matriz2.length-1 && i >= matriz2.length/2
                    if(j == 0 || i == matriz2.length/2 || j == matriz2.length-1 && i >= matriz2.length/2){
                        matriz2[i][j] = 1;
                    }else{
                        matriz2[i][j] = 0;
                    }
                }
                System.out.println();
            }

            //para inmprimir
            for (int i = 0; i < matriz2.length; i++) {
                for (int j = 0; j < matriz2[i].length; j++) {
                    System.out.print(matriz2[i][j]+ "\t");
                }
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
