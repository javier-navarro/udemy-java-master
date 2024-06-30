package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.dominio.ClienteDto;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.util.JpaUtil;

import java.util.Arrays;
import java.util.List;

public class HibernateQL {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        System.out.println("=======consultar todos============");
        List<Cliente> clientes = entityManager.createQuery("select c from Cliente c",Cliente.class).getResultList();

        clientes.forEach(System.out::println);

        System.out.println("=======consultar por id============");
        Cliente cliente = entityManager.createQuery("select c from Cliente c where c.id=:id", Cliente.class)
                .setParameter("id", 2L).getSingleResult();
        System.out.println(cliente);

        System.out.println("=======consultar nombre por id============");
        String nombreCliente = entityManager.createQuery("select c.nombre from Cliente c where c.id=:id", String.class)
                .setParameter("id", 2L).getSingleResult();
        System.out.println(nombreCliente);

        System.out.println("=======consultar por campos personalizados ============");
        Object[] objetoCliente = entityManager.createQuery("select c.id, c.nombre, c.apellido from Cliente c where c.id=:id ",Object[].class)
                .setParameter("id", 2L).getSingleResult();

        Long id = (Long) objetoCliente[0];
        String nombre = (String) objetoCliente[1];
        String apellido = (String) objetoCliente[2];
        System.out.println(id + " " +nombre + " " +apellido);

        System.out.println("=======consultar por campos personalizados lista============");
         List<Object[]>  registros = entityManager.createQuery("select c.id, c.nombre, c.apellido from Cliente c ",Object[].class)
                 .getResultList();
         /* son lo mismo que el de abajo
        for (Object[] reg: registros) {
            id = (Long) reg[0];
            nombre = (String) reg[1];
            apellido = (String) reg[2];
            System.out.println(id + " " +nombre + " " +apellido);
        }

          */

        registros.forEach(reg -> {
            Long idCli = (Long) reg[0];
            String nombreCli = (String) reg[1];
            String apellidoCli = (String) reg[2];
            System.out.println(idCli + " " +nombreCli + " " +apellidoCli);
        });

        System.out.println("=======consultar por cliente y forma de pago ============");
        registros = entityManager.createQuery("select c, c.formaPago from Cliente c", Object[].class)
                        .getResultList();

        registros.forEach(reg -> {
            Cliente c = (Cliente) reg[0];
            String formaPago = (String) reg[1];

            System.out.println(c + ""+ formaPago);
        });

        System.out.println("=======consulta que puebla y devuelve objeto entity de una clase personalizada ============");
        clientes = entityManager.createQuery("select new Cliente(c.nombre,c.apellido) from Cliente c",Cliente.class)
                        .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=======consulta que puebla y devuelve objeto DTO de una clase personalizada ============");
        /* Cuando se quiere ocupar una clase que no esta tageada como entity se debe poner el package completo de la clase */
        List<ClienteDto> clientesDto = entityManager.createQuery("select new org.jnavarro.hibernateapp.dominio.ClienteDto(c.nombre,c.apellido) from Cliente c", ClienteDto.class)
                .getResultList();
        clientesDto.forEach(System.out::println);

        System.out.println("=======consulta con nombres cliente ============");
        List<String> nombres = entityManager.createQuery("select c.nombre from Cliente c",String.class)
                        .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=======consulta con nombres unicos cliente ============");
        nombres= entityManager.createQuery("select distinct c.nombre from Cliente c",String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=======consulta con formas de pago unicos cliente ============");
        List<String> formasPago = entityManager.createQuery("select distinct c.formaPago from Cliente c",String.class)
                .getResultList();
        formasPago.forEach(System.out::println);

        System.out.println("=======consulta numero formas de pago unico ============");
        Long totalFormasPago = entityManager.createQuery("select count(distinct c.formaPago) from Cliente c",Long.class)
                .getSingleResult();
        System.out.println(totalFormasPago);

        System.out.println("=======consulta nombre y apellido concatenados ============");
        /* son lo mismo
        nombres = entityManager.createQuery("select concat(c.nombre,' ',c.apellido) from Cliente c",String.class)
                .getResultList();

         */
        nombres = entityManager.createQuery("select (c.nombre || ' '|| c.apellido) from Cliente c",String.class)
                .getResultList();
        nombres.forEach(System.out::println);


        System.out.println("=======consulta nombre y apellido concatenados mayuscula ============");
        nombres = entityManager.createQuery("select upper(concat(c.nombre,' ',c.apellido)) from Cliente c",String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=======consulta nombre y apellido concatenados minuscula ============");
        nombres = entityManager.createQuery("select lower(concat(c.nombre,' ',c.apellido)) from Cliente c",String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=======consulta para buscar con nombre ============");
        String param = "er";
        clientes  = entityManager.createQuery("select c from Cliente c where c.nombre like :parametro",Cliente.class)
                .setParameter("parametro", "%" +param+ "%").getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=======consulta por rangos between ============");
        clientes = entityManager.createQuery("select c from Cliente c where c.id between 2 and 5", Cliente.class)
                        .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=======consulta por rangos between caracteres ============");
        clientes = entityManager.createQuery("select c from Cliente c where c.nombre between 'A' and 'F' ", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=======order by ============");
        clientes = entityManager.createQuery("select c from Cliente c order by c.nombre desc, c.apellido desc", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("======= COUNT ============");
        Long total = entityManager.createQuery("select count(c) as total from Cliente c", Long.class)
                .getSingleResult();
        System.out.println(total);

        System.out.println("======= min ============");
        Long minId = entityManager.createQuery("select min(c.id) as minimo from Cliente c", Long.class)
                .getSingleResult();
        System.out.println(minId);

        System.out.println("======= max / ultimo id ============");
        Long maxId = entityManager.createQuery("select max(c.id) as maximo from Cliente c", Long.class)
                .getSingleResult();
        System.out.println(maxId);

        System.out.println("======= Consulta con nombre y su largo ============");
        registros = entityManager.createQuery("select c.nombre, length(c.nombre) from Cliente c", Object[].class)
                .getResultList();
        registros.forEach(reg -> {
            String nom = (String) reg[0];
            Integer largo = (Integer) reg[1];
            System.out.println(nom + " "+largo);
        });

        System.out.println("======= Consulta con nombre mas corto ============");
        Integer minLargoNombre = entityManager.createQuery("select min(length(c.nombre)) from Cliente c", Integer.class)
                .getSingleResult();
        System.out.println("minLargoNombre = " + minLargoNombre);

        System.out.println("======= Consulta con nombre mas largo ============");
        Integer maxLargoNombre = entityManager.createQuery("select max(length(c.nombre)) from Cliente c", Integer.class)
                .getSingleResult();
        System.out.println("maxLargoNombre = " + maxLargoNombre);


        System.out.println("======= Consulta resumen funciones agregacion count min max avg sum  ============");
        Object[] estadisticas = entityManager.createQuery("select min(c.id), max(c.id), sum(c.id), count(c.id), avg(length(c.nombre)) from Cliente c", Object[].class)
                .getSingleResult();
        Long min = (Long) estadisticas[0];
        Long max = (Long) estadisticas[1];
        Long sum = (Long) estadisticas[2];
        Long count = (Long) estadisticas[3];
        Double avg = (Double) estadisticas[4];
        System.out.println("min = " + min + ", max = " + max + ", sum = " + sum + ", count = " + count + ", avg = " + avg);

        System.out.println("======= Consulta con el nombre mas corto y  su largo  ============");
        registros = entityManager.createQuery("select c.nombre, length(c.nombre) from Cliente c where length(c.nombre) = (select min(length(c.nombre)) from Cliente c)", Object[].class)
                        .getResultList();
        registros.forEach(reg -> {
            String nom = (String)reg[0];
            Integer Largo = (Integer) reg[1];
            System.out.println("Largo  = " + Largo + ", nombre = " + nom);
        });

        System.out.println("======= Consulta para obtener el ultimo registro  ============");
        Cliente ultimoCliente = entityManager.createQuery("select c from Cliente c where c.id =(select max(c.id) from Cliente c)", Cliente.class)
                        .getSingleResult();
        System.out.println("ultimoCliente = " + ultimoCliente);

        System.out.println("======= Consulta where in   ============");
        clientes = entityManager.createQuery("select c from Cliente c where c.id in (1,2,9)", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("======= Consulta where in  con parametros ============");
        clientes = entityManager.createQuery("select c from Cliente c where c.id in :ids", Cliente.class)
                .setParameter("ids", Arrays.asList(1L,2L,10L))
                .getResultList();
        clientes.forEach(System.out::println);
        entityManager.close();
    }
}
