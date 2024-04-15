package org.jnavarro.patrones.singleton;

public class EjemploSingleton {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ConexionBdSingleton con = ConexionBdSingleton.getInstance();
            System.out.println("con = " + con);
        }
    }
}
