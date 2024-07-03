package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Alumno;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.entity.ClienteDetalle;
import org.jnavarro.hibernateapp.entity.Curso;
import org.jnavarro.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateManyToMany {

    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();

            Curso mate = new Curso("Matematicas", "fredy");
            Curso lengua = new Curso("Lenguaje", "sonia");

            Alumno obanai = new Alumno("Obanai", "Iguro");
            Alumno zanemi = new Alumno("Zanemi", "Zhinazugawa");

            obanai.getCursos().add(mate);
            obanai.getCursos().add(lengua);

            zanemi.getCursos().add(mate);

            entityManager.persist(obanai);
            entityManager.persist(zanemi);

            entityManager.getTransaction().commit();

            System.out.println(zanemi);
            System.out.println(obanai);
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
}
