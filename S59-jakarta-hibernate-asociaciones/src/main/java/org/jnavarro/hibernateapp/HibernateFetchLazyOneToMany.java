package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.util.JpaUtil;

public class HibernateFetchLazyOneToMany {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        Cliente cliente = entityManager.find(Cliente.class, 1L);
        //System.out.println(cliente.getDirecciones());
        System.out.println(cliente.getNombre());
        //System.out.println(cliente.getNombre() + ", direcciones: "+  cliente.getDirecciones());

        entityManager.close();
    }
}
