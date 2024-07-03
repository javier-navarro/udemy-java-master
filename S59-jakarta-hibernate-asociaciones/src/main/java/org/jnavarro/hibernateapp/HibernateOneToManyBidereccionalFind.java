package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.entity.Factura;
import org.jnavarro.hibernateapp.util.JpaUtil;

public class HibernateOneToManyBidereccionalFind {
    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();

            Cliente cliente = entityManager.find(Cliente.class, 13L);

            Factura factura1 = new Factura("compras de supermercado", 5000L);
            Factura factura2 = new Factura("compras de tecnologia", 7000L);

            //segunda forma de hacerlo
            /*
            cliente.getFacturas().add(factura1);
            cliente.getFacturas().add(factura2);

            factura1.setCliente(cliente);
            factura2.setCliente(cliente);
            
             */

            cliente.addFacturas(factura1);
            cliente.addFacturas(factura2);

            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
            System.out.println(cliente);

            //eliminamos objetos dependientes
            entityManager.getTransaction().begin();
            //Factura f3 = entityManager.find(Factura.class, 1L);

            Factura f3 = new Factura("compras de supermercado", 5000L);
            f3.setId(1L);

            //segunda forma
            /*
            cliente.getFacturas().remove(f3);
            f3.setCliente(null);
            */
            cliente.removeFactura(f3);
            entityManager.getTransaction().commit();

            System.out.println(cliente);
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
}
