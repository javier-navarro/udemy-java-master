package org.jnavarro.apiservlet.webapp.headers.service;

import jakarta.inject.Inject;
import org.jnavarro.apiservlet.webapp.headers.configs.ProductoServicePrincipal;
import org.jnavarro.apiservlet.webapp.headers.configs.Service;
import org.jnavarro.apiservlet.webapp.headers.interceptors.TransactionalJpa;
import org.jnavarro.apiservlet.webapp.headers.models.entities.Categoria;
import org.jnavarro.apiservlet.webapp.headers.models.entities.Producto;
import org.jnavarro.apiservlet.webapp.headers.repositories.Repository;
import org.jnavarro.apiservlet.webapp.headers.repositories.RepositoryJpa;

import java.util.List;
import java.util.Optional;


@ProductoServicePrincipal
@Service
@TransactionalJpa
public class ProductoServiceImpl implements ProductoService{
    @Inject
    @RepositoryJpa
    private Repository<Producto> repositoryJdbc;
    @Inject
    @RepositoryJpa
    private Repository<Categoria> repositoryCategoriaJdbc;

    @Override
    public List<Producto> listar() {
        try {
            return repositoryJdbc.listar();
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.porId(id));
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Producto producto) {
        try {
            repositoryJdbc.guardar(producto);
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            repositoryJdbc.eliminar(id);
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Categoria> listarCategoria() {
        try {
            return repositoryCategoriaJdbc.listar();
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        try {
            return Optional.ofNullable(repositoryCategoriaJdbc.porId(id));
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
