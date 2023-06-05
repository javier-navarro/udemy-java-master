package Seccion10_ClaseMath;

import java.util.Random;

//Clase 88
public class EjemploClaseMathRandom {
    public static void main(String[] args) {

        String colores[] = {"azul","amarillo","rojo","verde","blanco","negro"};
        double random = Math.random();
        System.out.println("random = " + random);
        
        random *= colores.length;
        System.out.println("random = " + random);
        
        //redondeo
        random = Math.floor(random);
        System.out.println("random = " + random);

        System.out.println("colores = " + colores[(int)random]);

        //Clase 89: Clase random
        Random randomObj = new Random();
        int randomInt = randomObj.nextInt();
        System.out.println("randomInt = " + randomInt);

        long randomLong = randomObj.nextLong();
        System.out.println("randomLong = " + randomLong);

        //se puede delimitar poniendo hasta el maximo que se puede ir entre parentesis
        randomInt = randomObj.nextInt(7);
        System.out.println("randomInt = " + randomInt);
    }
}
