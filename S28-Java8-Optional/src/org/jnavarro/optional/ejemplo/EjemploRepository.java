package org.jnavarro.optional.ejemplo;

import org.jnavarro.optional.ejemplo.models.Computador;
import org.jnavarro.optional.ejemplo.repositorio.ComputadorRepository;
import org.jnavarro.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepository {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepository();

        Computador computador = repositorio.filtrar("asus5");

        Optional<Computador> computadorOptional = repositorio.filtrarOptional("asus");

        if(computador != null){
            System.out.println(computador.getNombre());
        }else {
            System.out.println("no lo encontro");
        }

        if(computadorOptional.isPresent()){
            System.out.println(computadorOptional.get());
        }else {
            System.out.println("no lo encontro");
        }

        //Se puede resumir todo lo anterior en :
        repositorio.filtrarOptional("macbook").ifPresentOrElse(System.out::println,
                () -> System.out.println("no se encontro nada"));


    }
}
