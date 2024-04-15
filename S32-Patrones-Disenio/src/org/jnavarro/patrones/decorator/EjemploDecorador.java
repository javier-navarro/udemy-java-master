package org.jnavarro.patrones.decorator;

import org.jnavarro.patrones.decorator.decorador.MayusculaDecorador;
import org.jnavarro.patrones.decorator.decorador.ReemplazarEspacioDecorador;
import org.jnavarro.patrones.decorator.decorador.ReversaDecorador;
import org.jnavarro.patrones.decorator.decorador.SubrayadoDecorador;

import java.text.Format;

public class EjemploDecorador {
    public static void main(String[] args) {
        Formateable texto = new Texto("Hola Los maquina");

        MayusculaDecorador mayusculaDecorador = new MayusculaDecorador(texto);
        System.out.println("mayusculaDecorador = " + mayusculaDecorador.darFormato());
        
        ReversaDecorador reversaDecorador = new ReversaDecorador(texto);
        System.out.println("reversaDecorador = " + reversaDecorador.darFormato());

        SubrayadoDecorador subrayadoDecorador = new SubrayadoDecorador(texto);
        System.out.println("subrayadoDecorador = ");
        System.out.println(subrayadoDecorador.darFormato());

        ReemplazarEspacioDecorador reemplazarEspacioDecorador = new ReemplazarEspacioDecorador(texto);
        System.out.println("reemplazarEspacioDecorador.darFormato() = " + reemplazarEspacioDecorador.darFormato());
    }
}
