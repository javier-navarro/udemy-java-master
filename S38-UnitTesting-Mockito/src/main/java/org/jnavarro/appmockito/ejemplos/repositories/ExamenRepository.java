package org.jnavarro.appmockito.ejemplos.repositories;

import org.jnavarro.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepository {
    List<Examen> findAll();
    Examen guardar(Examen examen);
}
