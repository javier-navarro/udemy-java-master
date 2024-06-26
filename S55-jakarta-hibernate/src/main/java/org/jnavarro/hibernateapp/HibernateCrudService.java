package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.services.ClienteService;
import org.jnavarro.hibernateapp.services.ClienteServiceImpl;
import org.jnavarro.hibernateapp.util.JpaUtil;

import java.util.List;
import java.util.Optional;

public class HibernateCrudService {
    public static void main(String[] args) {
        EntityManager entityManager= JpaUtil.getEntityManager();
        ClienteService service = new ClienteServiceImpl(entityManager);

        System.out.println("================listar=========================");
        List<Cliente> clientes = service.listar();
        clientes.forEach(System.out::println);

        System.out.println("================porid=========================");
        Optional<Cliente> optional = service.porId(2L);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
        //otra forma de hacer ese if seria
        //optional.ifPresent(System.out::println);

        System.out.println("================Insertar=========================");
        Cliente cliente = new Cliente();
        cliente.setNombre("Erwin");
        cliente.setApellido("Smith");
        cliente.setFormaPago("paypal");

        service.guardar(cliente);
        System.out.println("Cliente guardado con exito");
        service.listar().forEach(System.out::println);

        System.out.println("================Editar=========================");
        Long id = cliente.getId();
        optional = service.porId(id);
        optional.ifPresent(c -> {
            c.setFormaPago("mercado pago");
            service.guardar(c);
            System.out.println("Cliente editado con exito");
            service.listar().forEach(System.out::println);
        });

        System.out.println("================eliminar=========================");
        id = cliente.getId();
        optional = service.porId(id);
        optional.ifPresent(c -> {
            service.eliminar(c.getId());
        });
        /*
        if (optional.isPresent()) {
            service.eliminar(id);
        }
         */
        entityManager.close();
    }
}
