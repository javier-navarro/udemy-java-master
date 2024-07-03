package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.entity.Factura;
import org.jnavarro.hibernateapp.util.JpaUtil;

public class HibernateOneToManyBidereccional {
    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();

            Cliente cliente = new Cliente("Tanjiro", "Kamado");
            cliente.setFormaPago("debito");

            Factura factura1 = new Factura("compras de supermercado", 5000L);
            Factura factura2 = new Factura("compras de tecnologia", 7000L);

            //segunda forma de hacerlo
            /*
            cliente.getFacturas().add(factura1);
            cliente.getFacturas().add(factura2);

            factura1.setCliente(cliente);
            factura2.setCliente(cliente);

             */

            cliente.addFacturas(factura1);
            cliente.addFacturas(factura2);

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
