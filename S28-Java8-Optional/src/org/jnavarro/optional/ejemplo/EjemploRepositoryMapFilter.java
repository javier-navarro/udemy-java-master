package org.jnavarro.optional.ejemplo;

import org.jnavarro.optional.ejemplo.models.Computador;
import org.jnavarro.optional.ejemplo.models.Fabricante;
import org.jnavarro.optional.ejemplo.models.Procesador;
import org.jnavarro.optional.ejemplo.repositorio.ComputadorRepository;
import org.jnavarro.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositoryMapFilter {
    public static void main(String[] args) {

        // se utiliza flapmap cuando retorna un objeto distinto como stream o optional.
        Repositorio<Computador> repositorio = new ComputadorRepository();
        Fabricante fabricante = repositorio.filtrarOptional("asus")
                //.map(c -> c.getProcesador())
                .map(Computador::getProcesador)
                .map(Procesador::getFabricante)
                //le ponemos que filtre por un tipo particular de marca
                .filter(f -> "intel".equalsIgnoreCase(f.getNombre()))
                .orElseThrow();
        System.out.println("fabricante = " + fabricante.getNombre());
    }
}
