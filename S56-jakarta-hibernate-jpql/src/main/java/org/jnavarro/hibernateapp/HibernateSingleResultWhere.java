package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.util.JpaUtil;

import java.util.Scanner;

public class HibernateSingleResultWhere {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EntityManager entityManager= JpaUtil.getEntityManager();
        Query query =  entityManager.createQuery("SELECT c FROM Cliente c where c.formaPago=?1", Cliente.class);

        System.out.println("ingrese una forma de pago: ");
        String pago = scanner.next();

        query.setParameter(1,pago);
        query.setMaxResults(1); //le da un maximo a la salida.
        Cliente c = (Cliente) query.getSingleResult();
        System.out.println(c);
        entityManager.close();
    }
}
