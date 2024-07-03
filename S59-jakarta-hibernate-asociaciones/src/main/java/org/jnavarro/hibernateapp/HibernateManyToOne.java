package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.entity.Factura;
import org.jnavarro.hibernateapp.util.JpaUtil;

public class HibernateManyToOne {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();
            Cliente cliente = new Cliente("Tanjiro", "Kamado");
            cliente.setFormaPago("credito");
            entityManager.persist(cliente);

            Factura factura = new Factura("Compras de oficina", 1000L);
            factura.setCliente(cliente);
            entityManager.persist(factura);
            System.out.println(factura);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
}
