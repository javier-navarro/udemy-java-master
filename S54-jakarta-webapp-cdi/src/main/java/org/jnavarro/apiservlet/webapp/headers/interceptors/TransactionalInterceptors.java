package org.jnavarro.apiservlet.webapp.headers.interceptors;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.jnavarro.apiservlet.webapp.headers.configs.MysqlConn;
import org.jnavarro.apiservlet.webapp.headers.service.ServiceJdbcException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

@TransactionalJdbc
@Interceptor
public class TransactionalInterceptors {
    @Inject
    @MysqlConn
    private Connection conn;

    @Inject
    private Logger log;

    @AroundInvoke
    public Object transactional(InvocationContext invocationContext) throws Exception {
        if(conn.getAutoCommit()){
            conn.setAutoCommit(false);
        }
        try{
            log.info( "-----> Iniciando Transaccion "+invocationContext.getMethod().getName()+ " de la clase "+invocationContext.getMethod().getDeclaringClass());
            Object resultado = invocationContext.proceed();
            conn.commit();
            log.info(" ----> Realizando commit y finalizando transaccion "+invocationContext.getMethod().getName());
            return resultado;
        }catch(ServiceJdbcException e) {
            conn.rollback();
            throw e;
        }

    }
}
