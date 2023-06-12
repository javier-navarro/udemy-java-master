package Seccion12_Arreglos;
import java.util.Arrays;

//Clase 96
public class EjemploArreglosFor {
    public static void main(String[] args) {

        String[] productos = new String[3];
        productos[0] = "De Bruyne";
        productos[1] = "Benzema";
        productos[2] = "Cristiano Ronaldo";
        Arrays.sort(productos);

        int total = productos.length-1;
        System.out.println("==========usando for=============");
        for (int i = 0; i <= total; i++) {
            System.out.println("indice" + i + ": " + productos[i]);
        }
        System.out.println("\n");
        System.out.println("==========usando foreach=============");
        for (String prod:productos){
            System.out.println("prod = " + prod);
        }

        System.out.println("==========usando while=============");
        int x=0;
        while (x < productos.length){
            System.out.println("indice" + x + ": " + productos[x]);
            x++;
        }

        System.out.println("==========usando do while=============");
        int j=0;
        do {
            System.out.println("indice" + j + ": " + productos[j]);
            j++;
        }while(j < productos.length);


        //ordena de forma alfabetica, tambien sirve para numeros.
        Arrays.sort(productos);

        System.out.println("\n");
        int[] numeros = new int[4];

        //para llenar el arreglo
        for (int i = 0; i < numeros.length; i++) {
           numeros[i] = i*3;
        }

        //para mostrar el arreglo
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("numeros = " + numeros[i]);
        }

    }
}
