package Seccion10_ClaseMath;
//Clase 86
/*
* La clase Math es una clase estatica final.
* */
public class EjemploClaseMath {
    public static void main(String[] args) {

        int absoluto = Math.abs(-3);
        System.out.println("absoluto = " + absoluto);

        absoluto = Math.abs(3);
        System.out.println("absoluto = " + absoluto);

        int max = Math.max(14, 2);
        System.out.println("max = " + max);

        int min = Math.min(12, 25);
        System.out.println("min = " + min);

        //redondea hacia arriba
        double techo = Math.ceil(3.5);
        System.out.println("techo = " + techo);

        //redondeea hacia abajo
        double piso = Math.floor(3.5);
        System.out.println("piso = " + piso);

        long entero = Math.round(Math.PI);
        System.out.println("entero = " + entero);

        // Clase 87

        //exponencial
        double exp = Math.exp(2);
        System.out.println("exp = " + exp);

        //logaritmo.
        double log = Math.log(10);
        System.out.println("log = " + log);

        double potencia = Math.pow(10,3);
        System.out.println("potencia = " + potencia);

        double raiz = Math.sqrt(5);
        System.out.println("raiz = " + raiz);

        double grados = Math.toDegrees(1.57);
        grados = Math.round(grados);
        System.out.println("Convertir radianes a grados = " + grados);

        double radianes = Math.toRadians(90.00);
        System.out.println("radianes = " + radianes);

        //seno
        System.out.println("sin(90) = " + Math.sin(radianes));

        //coseno
        System.out.println("cos(90) = " + Math.cos(radianes));



    }
}
