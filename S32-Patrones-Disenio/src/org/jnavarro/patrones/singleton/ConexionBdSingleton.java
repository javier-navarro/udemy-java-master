package org.jnavarro.patrones.singleton;

/*
*   Constructor privado, para que no se llame n veces
*   Generacion de metodo estatico
*
* */
public class ConexionBdSingleton {
    private static ConexionBdSingleton instancia;

    private ConexionBdSingleton(){
        System.out.println("conectandose a algun motor de base de datos");
    }

    public static ConexionBdSingleton getInstance(){
        //es lo mismo que esto instancia == null
        if (instancia == null){
            instancia = new ConexionBdSingleton();
        }
        return instancia;
    }


}
