package org.jnavarro.poointerfaces.repositorio;

import org.jnavarro.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio<T> {
    List<T> listar(String campo, Direccion direccion);
}
