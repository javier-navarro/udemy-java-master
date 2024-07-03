package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.entity.Factura;
import org.jnavarro.hibernateapp.util.JpaUtil;

public class HibernateManyToOneFind {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();
            Cliente cliente = entityManager.find(Cliente.class, 1L);

            Factura factura = new Factura("Compras de oficina", 1000L);
            factura.setCliente(cliente);
            entityManager.persist(factura);
            System.out.println(factura);
            System.out.println(factura.getCliente());
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
}
