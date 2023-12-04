package org.jnavarro.poointerfaces.repositorio;

import org.jnavarro.poointerfaces.modelo.Cliente;

import java.util.List;

public interface CrudRepositorio <T>{
    List<T> listar();
    T porId(Integer id);
    void crearCliente(T cliente);
    void editarCliente(T cliente);
    void eliminarCliente(Integer id);
}
