package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.entity.ClienteDetalle;
import org.jnavarro.hibernateapp.util.JpaUtil;

public class HibernateOneToOneBidireccionalFind {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();

            Cliente cliente = entityManager.find(Cliente.class, 3L);

            ClienteDetalle detalle = new ClienteDetalle(true,9000L);
            cliente.addDetalle(detalle);

            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
            System.out.println(cliente);
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
}
