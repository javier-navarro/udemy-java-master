package org.jnavarro.apiservlet.webapp.headers.repositories;

import jakarta.inject.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR,ElementType.METHOD,ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
public @interface RepositoryJpa {
}
