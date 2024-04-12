package org.jnavarro.optional.ejemplo;

import org.jnavarro.optional.ejemplo.models.Computador;
import org.jnavarro.optional.ejemplo.repositorio.ComputadorRepository;
import org.jnavarro.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositoryMetodosOrElse {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepository();

        Computador porDefecto = new Computador("HP", "Omen1");

        //orElse, si no encuentra lo que se busca devuelve un objeto del mismo tipo
        //encuentre o no lo buscado , igual pasa por el metodo else
        Computador computador = repositorio.filtrarOptional("2").orElse(valorDefecto());
        System.out.println("computador = " + computador);

        //orElseGet, si no lo encuentra devuelve un objeto supplier, debe ser del mismo tipo
        //computador = repositorio.filtrarOptional("macbook8").orElseGet(()-> {return porDefecto;});
        computador = repositorio.filtrarOptional("macbook8").orElseGet(()-> new Computador("Samsung","zenbook"));
        System.out.println(computador);
                


    }

    public static Computador valorDefecto(){
        System.out.println("Obteniendo el valor por defecto...");
        return new Computador("Xiaomi", "T3");
    }
}
