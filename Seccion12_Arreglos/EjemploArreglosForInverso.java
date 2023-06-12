package Seccion12_Arreglos;
import java.util.Arrays;

//Clase 97 - Iterando orden inverso de array
public class EjemploArreglosForInverso {
    public static void main(String[] args) {

        String[] productos = new String[3];
        productos[0] = "De Bruyne";
        productos[1] = "Benzema";
        productos[2] = "Cristiano Ronaldo";
        Arrays.sort(productos);

        int total = productos.length;
        System.out.println("==========usando for=============");
        for (int i = 0; i < total; i++) {
            System.out.println("indice" + i + ": " + productos[i]);
        }

        System.out.println("\n");
        //for inverso
        for (int i = 0; i < total; i++) {
            System.out.println("indice" + (total-1-i) + ": " + productos[total-1-i]);
        }
        System.out.println("==========usando for inveso 2=============");
        for (int i = total-1; i >= 0; i--) {
            System.out.println("indice" + i + ": " + productos[i]);
        }
    }
}
