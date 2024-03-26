package org.jnavarro.poointerfaces.repositorio.lista;

import org.jnavarro.poointerfaces.modelo.Cliente;
import org.jnavarro.poointerfaces.repositorio.AbstractaListRepositorio;
import org.jnavarro.poointerfaces.repositorio.Direccion;
import org.jnavarro.poointerfaces.repositorio.excepciones.LecturaDatoException;

import java.util.ArrayList;
import java.util.List;

public  class ClienteListRepositorio extends AbstractaListRepositorio<Cliente> {

    @Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;
        for (Cliente c: dataSource){
            if(c.getId()!=null && c.getId().equals(id)){
                resultado = c;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void editarCliente(Cliente cliente) throws LecturaDatoException {
        Cliente resultado = this.porId(cliente.getId());
        resultado.setNombre(cliente.getNombre());
        resultado.setApellido(cliente.getApellido());
    }

    @Override
    public List<Cliente> listar(String campo, Direccion direccion) {
        dataSource.sort((a, b) -> {
            int resultado = 0;
            if(direccion == Direccion.ASC){
                switch (campo){
                    case "id" -> resultado = a.getId().compareTo(b.getId());
                    case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
                    case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
                }
            } else if (direccion == Direccion.DESC) {
                switch (campo){
                    case "id" -> resultado = b.getId().compareTo(a.getId());
                    case "nombre" -> resultado = b.getNombre().compareTo(a.getNombre());
                    case "apellido" -> resultado = b.getApellido().compareTo(a.getApellido());
                }
            }
            return resultado;
        });
        return dataSource;
    }

}
