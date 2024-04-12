package org.jnavarro.optional.ejemplo;

import javax.swing.text.html.Option;
import java.util.Optional;

/*
    Se utiliza para representar un valor este presente o no
    evita lanzar excepciones nullpointer.
 */
public class EjemploOptional {
    public static void main(String[] args) {
        String nombre = "andres";
        //of: se le pasa un objeto , que no puede ser nulo.
        Optional<String> optional = Optional.of(nombre);
        System.out.println("optional = " + optional);
        //podemos preguntar si esta presente o no
        System.out.println(optional.isPresent());
        if(optional.isPresent()){
            //para rescatar valor metodo get
            System.out.println("hola "+ optional.get());
        }

        //esto es lo mismo que el if de arriba
        optional.ifPresent(valor -> {
            System.out.println("hola "+valor);
        });

        //que es lo mismo que esto
        optional.ifPresent( valor -> System.out.println("Hola "+valor));

        //para saber si esta vacio
        System.out.println(optional.isEmpty());

        //le daremos valores null
        //Optional.ofNullable es lo mismop que el of pero acepta nulos
        nombre = null;
        optional = Optional.ofNullable(nombre);
        System.out.println("optional = " + optional);
        System.out.println(optional.isPresent());
        System.out.println(optional.isEmpty());

        //solo funciona en java 9 ifPresentOrElse
        optional.ifPresentOrElse( valor -> System.out.println("Hola "+valor), () -> System.out.println("vacio..."));
        
        //para crear uno vacio metodo empty
        Optional<String> optionalVacio = Optional.empty();
        System.out.println("optionalVacio = " + optionalVacio);
        System.out.println(optionalVacio.isPresent());
    }
}
