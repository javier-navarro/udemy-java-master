package org.jnavarro.poointerfaces.repositorio.lista;

import org.jnavarro.poointerfaces.modelo.Producto;
import org.jnavarro.poointerfaces.repositorio.AbstractaListRepositorio;
import org.jnavarro.poointerfaces.repositorio.Direccion;
import org.jnavarro.poointerfaces.repositorio.excepciones.LecturaDatoException;

import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio <Producto> {
    @Override
    public void editarCliente(Producto productos) throws LecturaDatoException {
        Producto producto = porId(productos.getId());
        producto.setDescripcion(productos.getDescripcion());
        producto.setPrecio(productos.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion direccion) {
        dataSource.sort((a, b) -> {
            int resultado = 0;
            if (direccion == Direccion.ASC) {
                switch (campo) {
                    case "id" -> resultado = a.getId().compareTo(b.getId());
                    case "Descripcion" -> resultado = a.getDescripcion().compareTo(b.getDescripcion());
                    case "precio" -> resultado = a.getPrecio().compareTo(b.getPrecio());
                }
            } else if (direccion == Direccion.DESC) {
                switch (campo) {
                    case "id" -> resultado = b.getId().compareTo(a.getId());
                    case "Descripcion" -> resultado = b.getDescripcion().compareTo(a.getDescripcion());
                    case "precio" -> resultado = b.getPrecio().compareTo(a.getPrecio());
                }
            }
            return resultado;
        });
        return dataSource;
    }
}
