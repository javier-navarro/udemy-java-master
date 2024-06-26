package org.jnavarro.apiservlet.webapp.headers.configs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;
import org.jnavarro.apiservlet.webapp.headers.interceptors.Logging;
import org.jnavarro.apiservlet.webapp.headers.interceptors.TransactionalJdbc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@TransactionalJdbc
@ApplicationScoped
@Logging
@Stereotype
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Named
public @interface Service {
}
