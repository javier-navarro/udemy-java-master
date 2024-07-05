package org.jnavarro.apiservlet.webapp.headers.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.jnavarro.apiservlet.webapp.headers.configs.Repositorio;
import org.jnavarro.apiservlet.webapp.headers.models.entities.Categoria;

import java.util.List;

@RepositoryJpa
@Repositorio
public class CategoriaRepositoryJpaImpl implements Repository<Categoria>{

    @Inject
    private EntityManager entityManager;

    @Override
    public List<Categoria> listar() throws Exception {
        return entityManager.createQuery("from Categoria",Categoria.class).getResultList();
    }

    @Override
    public Categoria porId(Long id) throws Exception {
        return entityManager.find(Categoria.class,id);
    }

    @Override
    public void guardar(Categoria categoria) throws Exception {
        if (categoria.getId() != null && categoria.getId() >0) {
            entityManager.merge(categoria);
        }else{
            entityManager.persist(categoria);
        }
    }

    @Override
    public void eliminar(Long id) throws Exception {
        entityManager.remove(porId(id));
    }
}
