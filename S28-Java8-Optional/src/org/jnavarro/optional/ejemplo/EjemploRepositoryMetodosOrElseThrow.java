package org.jnavarro.optional.ejemplo;

import org.jnavarro.optional.ejemplo.models.Computador;
import org.jnavarro.optional.ejemplo.repositorio.ComputadorRepository;
import org.jnavarro.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositoryMetodosOrElseThrow {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepository();

        //orElseThrow, si no encuentra el valor arroja una excepcion, esta vacio o con un return que podemos definir nosotros
        Computador computador = repositorio.filtrarOptional("asus").orElseThrow(NullPointerException::new);
        System.out.println(computador);
        
        String archivo = "documentopdf";
        //optional soporta filter y map
        String extension = Optional.ofNullable(archivo)
                .filter(a -> a.contains("."))
                .map( a -> a.substring(archivo.lastIndexOf(".")+1))
                .orElseThrow();
        System.out.println("extension = " + extension);
    }

}
