package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.entity.Direccion;
import org.jnavarro.hibernateapp.util.JpaUtil;

public class HibernateOneToManyFind {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();
            Cliente cliente = entityManager.find(Cliente.class, 2L);

            Direccion d1 = new Direccion("liquiñe", 5497);
            Direccion d2 = new Direccion("juan jofre", 5560);

            cliente.getDirecciones().add(d1);
            cliente.getDirecciones().add(d2);

            //en vez de persist metemos merge porque ya existe
            entityManager.merge(cliente);

            entityManager.getTransaction().commit();
            System.out.println(cliente);

            // nueva transacciones para eliminar

            entityManager.getTransaction().begin();
            d1 = entityManager.find(Direccion.class, 1L);
            cliente.getDirecciones().remove(d1);

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
