package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.util.JpaUtil;

import javax.swing.*;


public class HibernateCrear {

    public static void main(String[] args) {
        EntityManager entityManager= JpaUtil.getEntityManager();
        try {

            String nombre = JOptionPane.showInputDialog("Ingresa nombre");
            String apellido = JOptionPane.showInputDialog("Ingresa apellidp");
            String formaPago = JOptionPane.showInputDialog("Ingresa forma pago");

            entityManager.getTransaction().begin();

            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setFormaPago(formaPago);

            entityManager.persist(cliente);
            entityManager.getTransaction().commit();

            System.out.println("**Id cliente registrado es: "+ cliente.getId());
            cliente = entityManager.find(Cliente.class,cliente.getId());
            System.out.println("cliente = " + cliente);
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }


    }
}
