package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Parameter;
import jakarta.persistence.criteria.*;
import org.hibernate.Criteria;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.util.JpaUtil;

import java.util.Arrays;
import java.util.List;

public class HibernateCriteria {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> query = criteria.createQuery(Cliente.class);

        //esto representa nuestra consulta
        Root<Cliente> from = query.from(Cliente.class);

        query.select(from);
        List<Cliente> clientes = entityManager.createQuery(query).getResultList();
        System.out.println("================ metodo listar ==============================");
        clientes.forEach(System.out::println);


        System.out.println("================ listar where equals ==============================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        query.select(from).where(criteria.equal(from.get("nombre"), "Mikasa"));

        //segunda forma de pasar parametros y el parametro se agrega a la ejecucion
        /*
        ParameterExpression<String> nombreParametro = criteria.parameter(String.class,"nombre");
        clientes = entityManager.createQuery(query).setParameter("nombre",nombreParametro).getResultList();

         */
        clientes = entityManager.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("================ listar where equals 2da forma ==============================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        ParameterExpression<String> nombreParametro = criteria.parameter(String.class,"nombre");

        query.select(from).where(criteria.equal(from.get("nombre"), nombreParametro));
        clientes = entityManager.createQuery(query).setParameter("nombre","Armin").getResultList();
        clientes.forEach(System.out::println);

        System.out.println("================ Usando where like para buscar clientes por nombre  ==============================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        ParameterExpression<String> nombreParamLike = criteria.parameter(String.class,"nombreParam");

        query.select(from).where(criteria.like(criteria.upper(from.get("nombre")), criteria.upper(nombreParamLike)));
        clientes = entityManager.createQuery(query).setParameter("nombreParam","%ed%").getResultList();
        clientes.forEach(System.out::println);

        System.out.println("================ ejemplo usando where between para rangos ==============================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        query.select(from).where(criteria.between(from.get("id"), 2L, 6L));
        clientes = entityManager.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("================ consulta where in ==============================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        query.select(from).where(from.get("nombre").in("Eren", "Mikasa"));
        clientes = entityManager.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("================ consulta where in segunda forma ==============================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        ParameterExpression<List> listParam = criteria.parameter(List.class, "nombres");
        query.select(from).where(from.get("nombre").in(listParam));
        clientes = entityManager.createQuery(query).setParameter("nombres", Arrays.asList("Reiner ", "Armin")).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("================ consulta mayor o igual que  (ge) ==============================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        query.select(from).where(criteria.ge(from.get("id"),3L));
        clientes = entityManager.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("================ consulta mayor que (gt) ==============================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        query.select(from).where(criteria.gt(criteria.length(from.get("nombre")),5L));
        clientes = entityManager.createQuery(query).getResultList();
        clientes.forEach(System.out::println);


        System.out.println("================ and y disyuncion or ==============================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        Predicate porNombre = criteria.equal(from.get("nombre"), "Eren");
        Predicate porFormaPago = criteria.equal(from.get("formaPago"), "debito");
        Predicate p3 = criteria.ge(from.get("id"), 4L);
        query.select(from).where(criteria.and(p3, criteria.or(porNombre,porFormaPago)));
        clientes = entityManager.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("================ consultas con order by asc - desc ==============================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        query.select(from).orderBy(criteria.asc(from.get("nombre")), criteria.desc(from.get("apellido")));
        clientes = entityManager.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("================ consultas por id ==============================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        ParameterExpression<Long> idParam = criteria.parameter(Long.class, "id");
        query.select(from).where(criteria.equal(from.get("id"),idParam));
        Cliente cliente = entityManager.createQuery(query)
                .setParameter("id", 1L).getSingleResult();
        System.out.println(cliente);

        System.out.println("================ consultas solo el nombre de los clientes ==============================");
        CriteriaQuery <String> queryString = criteria.createQuery(String.class);
        from = queryString.from(Cliente.class);
        queryString.select(from.get("nombre"));
        List<String> nombres = entityManager.createQuery(queryString).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("================ consultas solo el nombre de los clientes DISTINCT==============================");
        queryString = criteria.createQuery(String.class);
        from = queryString.from(Cliente.class);
        queryString.select(from.get("nombre")).distinct(true);
        nombres = entityManager.createQuery(queryString).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("================ consultas solo el nombre de los clientes DISTINCT + UPPER ==============================");
        queryString = criteria.createQuery(String.class);
        from = queryString.from(Cliente.class);
        queryString.select(criteria.upper(from.get("nombre"))).distinct(true);
        nombres = entityManager.createQuery(queryString).getResultList();
        nombres.forEach(System.out::println);


        System.out.println("================ consultas por nombre y apellidos concatenados==============================");
        queryString = criteria.createQuery(String.class);
        from = queryString.from(Cliente.class);

        queryString.select(criteria.upper(criteria.concat(criteria.concat(from.get("nombre")," "),from.get("apellido") )));
        nombres = entityManager.createQuery(queryString).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("================ consultas campos personalizados del entity cliente ==============================");
        CriteriaQuery<Object[]> queryObject = criteria.createQuery(Object[].class);
        from = queryObject.from(Cliente.class);

        queryObject.multiselect(from.get("id"),from.get("nombre"),from.get("apellido"));
        List<Object[]> registros = entityManager.createQuery(queryObject).getResultList();
        registros.forEach(reg->{
            Long id = (Long) reg[0];
            String nombre = (String) reg[1];
            String apellido = (String) reg[2];
            System.out.println("id = " + id+ ", nombre = " + nombre +", apellido = " + apellido);
        });


        System.out.println("================ consultas campos personalizados del entity cliente  con ]LIKE ==============================");
        queryObject = criteria.createQuery(Object[].class);
        from = queryObject.from(Cliente.class);

        queryObject.multiselect(from.get("id"),from.get("nombre"),from.get("apellido")).where(criteria.like(from.get("nombre"), "%ed%"));
        registros = entityManager.createQuery(queryObject).getResultList();
        registros.forEach(reg->{
            Long id = (Long) reg[0];
            String nombre = (String) reg[1];
            String apellido = (String) reg[2];
            System.out.println("id = " + id+ ", nombre = " + nombre +", apellido = " + apellido);
        });

        System.out.println("================ consultas campos personalizados del entity cliente x id ==============================");
        queryObject = criteria.createQuery(Object[].class);
        from = queryObject.from(Cliente.class);

        queryObject.multiselect(from.get("id"),from.get("nombre"),from.get("apellido")).where(criteria.equal(from.get("id"), 2L));
        Object [] registro = entityManager.createQuery(queryObject).getSingleResult();
        Long id = (Long) registro[0];
        String nombre = (String) registro[1];
        String apellido = (String) registro[2];
        System.out.println("id = " + id+ ", nombre = " + nombre +", apellido = " + apellido);


        System.out.println("================ COUNT REGISTROS ==============================");
        CriteriaQuery<Long> queryLong = criteria.createQuery(Long.class);
        from = queryLong.from(Cliente.class);
        queryLong.select(criteria.count(from.get("id")));
        Long count = entityManager.createQuery(queryLong).getSingleResult();

        System.out.println("count = " + count);

        System.out.println("================ max REGISTROS ==============================");
        queryLong = criteria.createQuery(Long.class);
        from = queryLong.from(Cliente.class);
        queryLong.select(criteria.max(from.get("id")));
        Long max = entityManager.createQuery(queryLong).getSingleResult();
        System.out.println("max = " + max);

        System.out.println("================ min REGISTROS ==============================");
        queryLong = criteria.createQuery(Long.class);
        from = queryLong.from(Cliente.class);
        queryLong.select(criteria.min(from.get("id")));
        Long min = entityManager.createQuery(queryLong).getSingleResult();
        System.out.println("min = " + min);

        System.out.println("================ sum REGISTROS ==============================");
        queryLong = criteria.createQuery(Long.class);
        from = queryLong.from(Cliente.class);
        queryLong.select(criteria.sum(from.get("id")));
        Long sum = entityManager.createQuery(queryLong).getSingleResult();
        System.out.println("sum = " + sum);

        System.out.println("================ ejemplo varias operaciones en 1 consulta ==============================");
        queryObject = criteria.createQuery(Object[].class);
        from = queryObject.from(Cliente.class);
        queryObject.multiselect(criteria.count(from.get("id")),criteria.sum(from.get("id")),criteria.max(from.get("id")), criteria.min(from.get("id")));
        registro = entityManager.createQuery(queryObject).getSingleResult();
        count = (Long) registro[0];
        sum = (Long) registro[1];
        max = (Long) registro[2];
        min = (Long) registro[3];
        System.out.println("count = " + count + ", sum = " + sum + ", max = " + max + ", min = " + min);



        entityManager.close();
    }
}
