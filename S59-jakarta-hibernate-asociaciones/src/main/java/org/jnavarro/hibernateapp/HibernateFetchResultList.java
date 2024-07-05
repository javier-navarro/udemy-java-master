package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateFetchResultList {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Cliente> clientes = entityManager.createQuery("select c from Cliente c",Cliente.class).getResultList();

        clientes.forEach(System.out::println);
        entityManager.close();
    }
}
