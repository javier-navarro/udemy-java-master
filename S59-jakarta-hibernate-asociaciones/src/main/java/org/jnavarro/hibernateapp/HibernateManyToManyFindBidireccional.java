package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Alumno;
import org.jnavarro.hibernateapp.entity.Curso;
import org.jnavarro.hibernateapp.util.JpaUtil;

public class HibernateManyToManyFindBidireccional {

    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();

            Curso lengua = entityManager.find(Curso.class, 1L);
            Curso mate = entityManager.find(Curso.class, 2L);

            Alumno obanai = entityManager.find(Alumno.class, 1L);
            Alumno zanemi = entityManager.find(Alumno.class, 2L);

            obanai.addCurso(mate);
            obanai.addCurso(lengua);

            zanemi.addCurso(mate);

            entityManager.getTransaction().commit();

            System.out.println(zanemi);
            System.out.println(obanai);

            entityManager.getTransaction().begin();

            Curso c2 = new Curso("Java", "kaiju");
            c2.setId(2L);
            obanai.removeCurso(c2);
            entityManager.getTransaction().commit();
            System.out.println(c2);

        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
}
