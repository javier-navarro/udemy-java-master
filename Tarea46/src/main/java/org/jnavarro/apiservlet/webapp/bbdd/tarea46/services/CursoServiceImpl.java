package org.jnavarro.apiservlet.webapp.bbdd.tarea46.services;


import org.jnavarro.apiservlet.webapp.bbdd.tarea46.model.Curso;
import org.jnavarro.apiservlet.webapp.bbdd.tarea46.model.CursoRepositorioImpl;
import org.jnavarro.apiservlet.webapp.bbdd.tarea46.repositories.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CursoServiceImpl implements CursoService{
    private Repository<Curso> repository;

    public CursoServiceImpl(Connection connection) {
        this.repository = new CursoRepositorioImpl(connection);
    }

    @Override
    public List<Curso> listar() {
        try {
            return repository.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Curso> porNombre(String nombre) {
        try {
            return repository.porNombre(nombre);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}