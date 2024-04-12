package org.jnavarro.optional.ejemplo.repositorio;

import org.jnavarro.optional.ejemplo.models.Computador;
import org.jnavarro.optional.ejemplo.models.Fabricante;
import org.jnavarro.optional.ejemplo.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepository implements  Repositorio<Computador>{

    private List<Computador> datasource;

    public ComputadorRepository(){
        datasource = new ArrayList<>();
        Procesador procesador = new Procesador("GLX-1", new Fabricante("Intel"));
        Computador computador = new Computador("asus", "glx");
        computador.setProcesador(procesador);
        this.datasource.add(computador);
        this.datasource.add(new Computador("macbook", "pro"));
    }
    @Override
    public Computador filtrar(String nombre) {
        for(Computador c : datasource){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                return c;
            }
        }
        return null;
    }

    @Override
    public Optional<Computador> filtrarOptional(String nombre) {
        for(Computador c : datasource){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    //el metodo de abajo hace exactamente lo mismo que el filtrarOptional
    //devuelve lo primero que encuetra, en caso de no encontrar devuelve vacio
    public Optional<Computador> filtrarOptional2(String nombre) {
        return datasource.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }
}
