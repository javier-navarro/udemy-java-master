package org.jnavarro.optional.ejemplo.repositorio;

import org.jnavarro.optional.ejemplo.models.Computador;

import java.util.Optional;

public interface Repositorio<T>{
    Computador filtrar(String nombre);

    Optional<Computador> filtrarOptional(String nombre);
}
