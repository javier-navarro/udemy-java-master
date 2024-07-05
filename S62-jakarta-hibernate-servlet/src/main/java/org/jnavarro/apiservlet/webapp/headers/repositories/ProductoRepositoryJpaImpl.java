package org.jnavarro.apiservlet.webapp.headers.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.jnavarro.apiservlet.webapp.headers.configs.Repositorio;
import org.jnavarro.apiservlet.webapp.headers.models.entities.Producto;

import java.util.List;

@RepositoryJpa
@Repositorio
public class ProductoRepositoryJpaImpl implements Repository<Producto>{

    @Inject
    private EntityManager entityManager;

    @Override
    public List<Producto> listar() throws Exception {
        return entityManager.createQuery("from Producto", Producto.class).getResultList();
    }

    @Override
    public Producto porId(Long id) throws Exception {
        return entityManager.find(Producto.class, id);
    }

    @Override
    public void guardar(Producto producto) throws Exception {
        if (producto.getId() != null && producto.getId() > 0) {
            entityManager.merge(producto);
        } else {
            entityManager.persist(producto);
        }
    }

    @Override
    public void eliminar(Long id) throws Exception {
        Producto producto = porId(id);
        entityManager.remove(producto);
    }
}
