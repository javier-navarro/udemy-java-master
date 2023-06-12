package Seccion12_Arreglos;
import java.util.Arrays;

//Clase 97 - Iterando orden inverso de array
public class EjemploArreglosForInversoMutable {
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

        for (int i = 0; i < total/2; i++) {
            String actual = productos[i];
            String inverso = productos[total-1-i];
            productos[i] = inverso;
            productos[total-1-i] = actual;
        }

        System.out.println("==========usando for inverso=============");
        for (int i = 0; i < total; i++) {
            System.out.println("indice" + i + ": " + productos[i]);
        }


    }
}
