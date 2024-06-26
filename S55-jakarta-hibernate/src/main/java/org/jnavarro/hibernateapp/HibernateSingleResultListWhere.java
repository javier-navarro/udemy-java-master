package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.util.JpaUtil;

import java.util.List;
import java.util.Scanner;

public class HibernateSingleResultListWhere {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EntityManager entityManager= JpaUtil.getEntityManager();
        Query query =  entityManager.createQuery("SELECT c FROM Cliente c where c.formaPago=?1", Cliente.class);

        System.out.println("ingrese una forma de pago: ");
        String pago = scanner.next();

        query.setParameter(1,pago);

        List <Cliente> clientes = query.getResultList();
        System.out.println(clientes);
        entityManager.close();
    }
}
