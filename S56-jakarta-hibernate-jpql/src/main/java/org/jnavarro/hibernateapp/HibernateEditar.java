package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.util.JpaUtil;

import javax.swing.*;

public class HibernateEditar {
    public static void main(String[] args) {
        EntityManager entityManager= JpaUtil.getEntityManager();
        try{
            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingresa id de cliente a modificar"));
            Cliente cliente = entityManager.find(Cliente.class, id);

            String nombre = JOptionPane.showInputDialog("ingrese el nombre: ", cliente.getNombre());
            String apellido = JOptionPane.showInputDialog("ingrese el apellido: ", cliente.getApellido());
            String pago = JOptionPane.showInputDialog("ingrese la forma pago: ", cliente.getFormaPago());
            entityManager.getTransaction().begin();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setFormaPago(pago);
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();

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
