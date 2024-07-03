package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.entity.ClienteDetalle;
import org.jnavarro.hibernateapp.util.JpaUtil;

public class HibernateOneToOneBidireccional {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();

            Cliente cliente = new Cliente("Obanai", "Iguro");
            cliente.setFormaPago("credito");

            ClienteDetalle clienteDetalle = new ClienteDetalle(true,9000L);
            //segunda forma
            /*
            cliente.setDetalle(clienteDetalle);
            clienteDetalle.setCliente(cliente);
                         */

            cliente.addDetalle(clienteDetalle);
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
