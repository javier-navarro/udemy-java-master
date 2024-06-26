package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.util.JpaUtil;

import java.util.Scanner;

public class HibernatePorId {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese id: ");
        Long id = scanner.nextLong();

        EntityManager entityManager= JpaUtil.getEntityManager();
        Cliente cliente =  entityManager.find(Cliente.class, id);
        System.out.println(cliente);

        Cliente cliente2 =  entityManager.find(Cliente.class, id);
        System.out.println(cliente2);

        entityManager.close();
    }
}
