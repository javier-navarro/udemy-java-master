package org.jnavarro.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion<T> implements Iterable<T>{

    public List<T> objetos;
    private int max;

    public Camion( int max) {
        this.objetos = new ArrayList<T>();
        this.max = max;
    }

    public void add(T object){
        if(this.objetos.size() <= max){
            this.objetos.add(object);
        } else {
            throw new RuntimeException("no more space,");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.objetos.iterator();
    }
}
