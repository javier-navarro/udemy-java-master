package Seccion12_Arreglos;

//Clase 103 - Combinar 2 arreglos en un tercero
//Clase 104 - con multiples elementos
public class EjemploArreglosCombinados {
    public static void main(String[] args) {
        int[] a,b,c,d;
        a = new int[10];
        b = new int[10];
        c = new int[20];
        d = new int[20];

        System.out.println("====ARREGLOA=======");
        for (int i = 0; i <a.length; i++) {
            a[i] = i+1;
            System.out.println("a[i] = " + a[i]);
        }

        System.out.println("====ARREGLOB=======");
        for (int i = 0; i <b.length ; i++) {
            b[i] = (i+1) * 5;
            System.out.println("b[i] = " + b[i]);
        }

        int aux = 0;
        for (int i = 0; i <10 ; i++) {
            c[aux++] = a[i];
            c[aux++] = b[i];
        }

        System.out.println("====ARREGLOC=======");
        for (int i = 0; i <c.length ; i++) {
            System.out.println("c[i] = " + c[i]);
        }

        int aux2=0;
        for (int i = 0; i < 10 ; i+=2) {
            for (int j = 0; j < 2; j++) {
                d[aux2++] = a[i+j];
            }
            for (int j = 0; j < 2; j++) {
                d[aux2++] = b[i+j];
            }
        }

        System.out.println("====ARREGLOD=======");
        for (int i = 0; i < d.length ; i++) {
            System.out.println(i +" = " + d[i]);
        }
    }
}
