package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.util.JpaUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HibernateCriteriaBusquedaDinamica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("filtro para nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("filtro para apellido: ");
        String apellido = scanner.nextLine();

        System.out.println("filtro para forma pago: ");
        String formaPago = scanner.nextLine();

        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Cliente> query = cb.createQuery(Cliente.class);
        Root<Cliente> from = query.from(Cliente.class);

        List<Predicate> condiciones = new ArrayList<>();

        if (nombre != null && !nombre.isEmpty()) {
            condiciones.add(cb.equal(from.get("nombre"), nombre));
        }

        if (apellido != null && !apellido.isEmpty()) {
            condiciones.add(cb.equal(from.get("apellido"), apellido));
        }

        if (formaPago != null && !formaPago.isEmpty()) {
            condiciones.add(cb.equal(from.get("formaPago"), formaPago));
        }

        query.select(from).where(cb.and(condiciones.toArray(new Predicate[condiciones.size()])));
        List<Cliente> clientes = entityManager.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        entityManager.close();
    }
}
