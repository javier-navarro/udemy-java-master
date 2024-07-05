package org.jnavarro.hibernateapp;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Alumno;
import org.jnavarro.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateFetchManyToMany {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Alumno> alumnos = entityManager.createQuery("select distinct a from Alumno a left outer join fetch a.cursos ", Alumno.class).getResultList();

        //alumnos.forEach(System.out::println);
        alumnos.forEach(a -> {
            System.out.println(a.getNombre()+ ", cursos: " + a.getCursos());
        });
        entityManager.close();
    }
}
