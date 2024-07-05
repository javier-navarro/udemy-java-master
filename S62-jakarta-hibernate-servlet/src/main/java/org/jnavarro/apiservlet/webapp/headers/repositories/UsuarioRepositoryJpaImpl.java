package org.jnavarro.apiservlet.webapp.headers.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.jnavarro.apiservlet.webapp.headers.configs.Repositorio;
import org.jnavarro.apiservlet.webapp.headers.models.entities.Usuario;

import java.util.List;
@RepositoryJpa
@Repositorio
public class UsuarioRepositoryJpaImpl implements UsuarioRepository{

    @Inject
    private EntityManager entityManager;

    @Override
    public List<Usuario> listar() throws Exception {
        return entityManager.createQuery("from Usuario",Usuario.class).getResultList();
    }

    @Override
    public Usuario porId(Long id) throws Exception {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public void guardar(Usuario usuario) throws Exception {
        if (usuario.getId() != null && usuario.getId() > 0) {
            entityManager.merge(usuario);
        }else {
            entityManager.persist(usuario);
        }
    }

    @Override
    public void eliminar(Long id) throws Exception {
        entityManager.remove(porId(id));
    }

    @Override
    public Usuario porUsername(String username) throws Exception {
        return entityManager.createQuery("select u from Usuario u where  u.username = :username", Usuario.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}
