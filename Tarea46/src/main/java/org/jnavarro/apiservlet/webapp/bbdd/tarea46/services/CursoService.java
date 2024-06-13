package org.jnavarro.apiservlet.webapp.bbdd.tarea46.services;

import org.jnavarro.apiservlet.webapp.bbdd.tarea46.model.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> listar();
    List<Curso> porNombre(String nombre);
}