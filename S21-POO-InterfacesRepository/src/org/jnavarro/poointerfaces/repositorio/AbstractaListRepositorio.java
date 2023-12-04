package org.jnavarro.poointerfaces.repositorio;

import org.jnavarro.poointerfaces.modelo.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio <T extends BaseEntity> implements OrdenablePaginableCrudRepositorio<T>{

    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) {
        T resultado = null;
        for (T c: dataSource){
            if(c.getId()!=null && c.getId().equals(id)){
                resultado = c;
                break;
            }
        }
        return resultado;
    }


    @Override
    public void crearCliente(T cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void eliminarCliente(Integer id) {
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
