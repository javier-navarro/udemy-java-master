package Seccion12_Arreglos;


//Clase 99 - Ordenamiento algoritmo burbuja
//Clase 100
//Clase 101 - Reutilizando algoritmo burbuja
public class EjemploArreglosOrdenamientoBurbuja {
    public static void sortBurbuja (Object[] arreglo){

        int total = arreglo.length;
        int contador = 0;

        for (int i = 0; i < total -1; i++) {
            for (int j = 0; j < total -1 -i; j++) {
                //puede ser de tipo Comparable o Integer
                if ( ((Comparable)arreglo[j+1]).compareTo(arreglo[j]) < 0 ) {
                    Object auxiliar = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = auxiliar;
                }
            }
        }
        contador++;
        System.out.println("contador = " + contador);
    }

    public static void main(String[] args) {

        String[] productos = new String[3];
        productos[0] = "De Bruyne";
        productos[1] = "Benzema";
        productos[2] = "Cristiano Ronaldo";

        int total = productos.length;

        sortBurbuja(productos);

        System.out.println("==========usando for=============");
        for (int i = 0; i < total; i++) {
            System.out.println("indice" + i + ": " + productos[i]);
        }

        System.out.println("\n");
        Integer[] numeros = new Integer[4];

        numeros[0] = 1;
        numeros[1] = -15;
        numeros[2] = 7;
        numeros[3] = 4;

        sortBurbuja(numeros);

        for (int i = 0; i < numeros.length ; i++) {
            System.out.println("indice" + i + ": " + numeros[i]);
        }
    }


}
