package org.jnavarro.apiservlet.webapp.headers.interceptors;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.persistence.EntityManager;
import org.jnavarro.apiservlet.webapp.headers.service.ServiceJdbcException;

import java.util.logging.Logger;

@TransactionalJpa
@Interceptor
public class TransactionalJpaInterceptors {
    @Inject
    private EntityManager conn;

    @Inject
    private Logger log;

    @AroundInvoke
    public Object transactional(InvocationContext invocationContext) throws Exception {

        try{
            log.info( "-----> Iniciando Transaccion "+invocationContext.getMethod().getName()+ " de la clase "+invocationContext.getMethod().getDeclaringClass());
            conn.getTransaction().begin();
            Object resultado = invocationContext.proceed();
            conn.getTransaction().commit();
            log.info(" ----> Realizando commit y finalizando transaccion "+invocationContext.getMethod().getName());
            return resultado;
        }catch(ServiceJdbcException e) {
            conn.getTransaction().rollback();
            throw e;
        }

    }
}
