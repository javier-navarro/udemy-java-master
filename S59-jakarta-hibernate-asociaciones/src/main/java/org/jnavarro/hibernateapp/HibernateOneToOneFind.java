package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.entity.ClienteDetalle;
import org.jnavarro.hibernateapp.util.JpaUtil;

public class HibernateOneToOneFind {

    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();

            Cliente cliente = entityManager.find(Cliente.class, 2L);

            ClienteDetalle clienteDetalle = new ClienteDetalle(true,5600L);
            entityManager.persist(clienteDetalle);


            cliente.setDetalle(clienteDetalle);
            System.out.println(clienteDetalle);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
}
