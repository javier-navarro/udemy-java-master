package org.jnavarro.patrones.observer.ejemplos;

import org.jnavarro.patrones.observer.Corporacion;
import org.jnavarro.patrones.observer.UsuarioRepositorio;

public class EjemploObserver2 {
    public static void main(String[] args) {
        Corporacion google = new Corporacion("Google", 1000);
        UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();
        usuarioRepositorio.addObserver((o, u) -> System.out.println("Enviando mail al usuario "+ u));
        usuarioRepositorio.addObserver((o, u) -> System.out.println("Enviando mail al administrador"));
        usuarioRepositorio.addObserver((o, u) -> System.out.println("guardando info del usuario " +
                        u +" en logs."));
        usuarioRepositorio.crearUsuario("Eren Jaeger");

    }
}
