package Seccion13_Matrices;
//Clase 120 Buscar elemento en una matriz con etiquetas y break
public class EjemploMatricesBuscar {
    public static void main(String[] args) {

        int[][] matrizEnteros = {
                {35, 90, 3, 1978},
                {15, 2020, 10, 5},
                {677, 127, 32767, 11999}
        };

        int busqueda = 15, i=0, j=0;
        boolean encontrado = false;

        buscar: for (i = 0; i < matrizEnteros.length; i++) {
            for (j = 0; j < matrizEnteros[i].length; j++) {
                if (matrizEnteros[i][j] == busqueda) {
                    encontrado = true;
                    break buscar;
                }
            }
        }
        if(encontrado){
            System.out.println("Encontrado "+ busqueda+ " en las cordenadas " + i + ","+j);
        }else{
            System.out.println("elemento no encontrado");
        }
    }
}
