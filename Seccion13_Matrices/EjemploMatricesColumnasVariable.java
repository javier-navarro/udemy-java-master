package Seccion13_Matrices;
//Clase 119 - Tamaño de columnas variables en una matriz
public class EjemploMatricesColumnasVariable {
    public static void main(String[] args) {
        int[][] matriz = new int[3][];

        matriz[0] = new int[2];
        matriz[1] = new int[3];
        matriz[2] = new int[4];

        System.out.println("Matriz length: "+ matriz.length);
        System.out.println("Fila 0 = " + matriz[0].length);
        System.out.println("fila 1 = " + matriz[1].length);
        System.out.println("fila 2 = " + matriz[2].length);

        // mostrando los datos de la matriz, por default sale todo en 0
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
