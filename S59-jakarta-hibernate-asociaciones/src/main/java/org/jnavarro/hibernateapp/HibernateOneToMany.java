package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.entity.Direccion;
import org.jnavarro.hibernateapp.entity.Factura;
import org.jnavarro.hibernateapp.util.JpaUtil;

public class HibernateOneToMany {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();
            Cliente cliente = new Cliente("Tanjiro", "Kamado");
            cliente.setFormaPago("mercado pago");

            Direccion d1 = new Direccion("liquiñe", 5497);
            Direccion d2 = new Direccion("juan jofre", 5560);

            cliente.getDirecciones().add(d1);
            cliente.getDirecciones().add(d2);
            entityManager.persist(cliente);

            entityManager.getTransaction().commit();
            System.out.println(cliente);

            // nueva transacciones para eliminar

            entityManager.getTransaction().begin();
            entityManager.find(Cliente.class, cliente.getId());
            cliente.getDirecciones().remove(d1);
            System.out.println(cliente);

            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
}
