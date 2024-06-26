package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateListar {
    public static void main(String[] args) {
        EntityManager entityManager= JpaUtil.getEntityManager();
        //SE LE DA EL NOMBRE DE LA ENTIDAD, NO EL NOMBRE DE TABLA
        List<Cliente> clientes =  entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        //clientes.forEach(c-> System.out.println(c));
        entityManager.close();
    }
}
