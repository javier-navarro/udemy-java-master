package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Alumno;
import org.jnavarro.hibernateapp.entity.Curso;
import org.jnavarro.hibernateapp.util.JpaUtil;

public class HibernateManyToManyBidireccional {

    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();

            Curso mate = new Curso("Matematicas", "fredy");
            Curso lengua = new Curso("Lenguaje", "sonia");

            Alumno obanai = new Alumno("Obanai", "Iguro");
            Alumno zanemi = new Alumno("Zanemi", "Zhinazugawa");

            obanai.addCurso(mate);
            obanai.addCurso(lengua);

            zanemi.addCurso(mate);

            entityManager.persist(obanai);
            entityManager.persist(zanemi);

            entityManager.getTransaction().commit();

            System.out.println(zanemi);
            System.out.println(obanai);

            entityManager.getTransaction().begin();

            Curso c2 = new Curso("Java", "kaiju");
            c2.setId(3L);
            obanai.getCursos().remove(c2);
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
