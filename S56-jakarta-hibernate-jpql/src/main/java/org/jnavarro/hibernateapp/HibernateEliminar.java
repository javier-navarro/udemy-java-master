package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.util.JpaUtil;

import javax.swing.*;

public class HibernateEliminar {
    public static void main(String[] args) {
        EntityManager entityManager= JpaUtil.getEntityManager();
        try{
            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingresa id de cliente a eliminar"));
            Cliente cliente = entityManager.find(Cliente.class, id);

            entityManager.getTransaction().begin();

            entityManager.remove(cliente);
            entityManager.getTransaction().commit();

        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
}
