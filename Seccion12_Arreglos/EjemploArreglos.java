package Seccion12_Arreglos;
import java.util.Arrays;

//Clase 94 -95
public class EjemploArreglos {
    public static void main(String[] args) {

        String[] productos = new String[3];
        productos[0] = "De Bruyne";
        productos[1] = "Benzema";
        productos[2] = "Cristiano Ronaldo";

        //ordena de forma alfabetica, tambien sirve para numeros.
        Arrays.sort(productos);

        String prod1 = productos[0];
        String prod2 = productos[1];
        String prod3 = productos[2];

        System.out.println("prod1 = " + prod1);
        System.out.println("prod2 = " + prod2);
        System.out.println("prod3 = " + prod3);

        System.out.println("\n");
        int[] numeros = new int[4];

        numeros[0] = 1;
        numeros[1] = Integer.valueOf(2);
        numeros[2] = 3;
        numeros[3] = 4;
        //numeros[4] = 5;

        int i = numeros[0];
        int j = numeros[1];
        int k = numeros[2];
        int l = numeros[numeros.length - 1]; //sacar el ultimo valor dinamicamente.

        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + k);
        System.out.println("l = " + l);
    }
}
