package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.util.JpaUtil;

//esta forma sirve para hacer menos consultas a la bd
public class HibernateFetchLazyOneToManyJoinFetch {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        Cliente cliente = entityManager.createQuery("select c from Cliente c left outer join fetch c.direcciones " +
                        "left join fetch c.detalle where c.id =:id", Cliente.class)
                .setParameter("id", 1L)
                .getSingleResult();
        //System.out.println(cliente.getNombre());
        System.out.println(cliente.getNombre() + ", direcciones: "+  cliente.getDirecciones());

        entityManager.close();
    }
}
