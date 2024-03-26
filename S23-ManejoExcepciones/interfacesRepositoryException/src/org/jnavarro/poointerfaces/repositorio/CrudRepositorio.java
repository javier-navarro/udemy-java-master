package org.jnavarro.poointerfaces.repositorio;

import org.jnavarro.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.jnavarro.poointerfaces.repositorio.excepciones.EscrituraAccesoDatos;
import org.jnavarro.poointerfaces.repositorio.excepciones.LecturaDatoException;

import java.util.List;

public interface CrudRepositorio <T>{
    List<T> listar();
    T porId(Integer id) throws AccesoDatoException;
    void crearCliente(T cliente) throws AccesoDatoException;
    void editarCliente(T cliente) throws AccesoDatoException;
    void eliminarCliente(Integer id) throws AccesoDatoException;
}
