package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Alumno;
import org.jnavarro.hibernateapp.entity.Curso;
import org.jnavarro.hibernateapp.util.JpaUtil;

public class HibernateManyToManyFind {

    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();

            Curso lengua = entityManager.find(Curso.class, 1L);
            Curso mate = entityManager.find(Curso.class, 2L);

            Alumno obanai = entityManager.find(Alumno.class, 1L);
            Alumno zanemi = entityManager.find(Alumno.class, 2L);

            obanai.getCursos().add(mate);
            obanai.getCursos().add(lengua);

            zanemi.getCursos().add(mate);

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
