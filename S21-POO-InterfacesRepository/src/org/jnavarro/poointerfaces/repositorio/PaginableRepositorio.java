package org.jnavarro.poointerfaces.repositorio;

import org.jnavarro.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio <T>{
    List<T> listar(int desde, int hasta);
}
