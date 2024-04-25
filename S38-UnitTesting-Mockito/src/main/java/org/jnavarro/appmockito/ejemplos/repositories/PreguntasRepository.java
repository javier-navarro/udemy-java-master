package org.jnavarro.appmockito.ejemplos.repositories;

import org.jnavarro.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface PreguntasRepository {
    List<String> findPreguntasPorExamenId(Long id);
    void guardarVarias(List<String>preguntas);
}
