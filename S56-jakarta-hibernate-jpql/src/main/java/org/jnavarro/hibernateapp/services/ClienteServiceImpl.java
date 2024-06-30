package org.jnavarro.hibernateapp.services;

import jakarta.persistence.EntityManager;
import org.jnavarro.hibernateapp.entity.Cliente;
import org.jnavarro.hibernateapp.repositories.ClienteRepository;
import org.jnavarro.hibernateapp.repositories.CrudRepository;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements ClienteService {

    private EntityManager entityManager;
    private CrudRepository<Cliente> repository;

    public ClienteServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.repository = new ClienteRepository(entityManager);
    }

    @Override
    public List<Cliente> listar() {
       return repository.listar();
    }

    @Override
    public Optional<Cliente> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void guardar(Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            repository.guardar(cliente);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            entityManager.getTransaction().begin();
            repository.eliminar(id);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
