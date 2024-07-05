package org.jnavarro.hibernateapp;

import com.mysql.cj.xdevapi.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.hibernate.Criteria;
import org.jnavarro.hibernateapp.entity.Alumno;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.entity.Factura;
import org.jnavarro.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateFetchManyToOneCriteria {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery <Factura> query = builder.createQuery(Factura.class);
        Root<Factura> facturaRoot = query.from(Factura.class);

        Join<Factura, Cliente> cliente = (Join) facturaRoot.fetch("cliente", JoinType.LEFT);
        cliente.fetch("detalle",JoinType.LEFT);

        query.select(facturaRoot).where(builder.equal(cliente.get("id"),1L));

        List<Factura> facturas = entityManager.createQuery(query).getResultList();

        facturas.forEach(System.out::println);
        facturas.forEach(f->{
            System.out.println(f.getDescripcion()+ ", cliente: "+f.getCliente().getNombre());
        });

        entityManager.close();
    }
}
