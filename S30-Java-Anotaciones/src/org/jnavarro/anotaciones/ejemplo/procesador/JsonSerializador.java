package org.jnavarro.anotaciones.ejemplo.procesador;

import org.jnavarro.anotaciones.ejemplo.Init;
import org.jnavarro.anotaciones.ejemplo.JsonAtributo;
import org.jnavarro.anotaciones.ejemplo.procesador.exception.JsonSerializadorException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonSerializador {

    public static void inicializarObjeto(Object objeto){
        if(Objects.isNull(objeto)){
            throw new JsonSerializadorException("El objeto serializable no pude ser null");
        }
        Method[] metodos = objeto.getClass().getDeclaredMethods();
        Arrays.stream(metodos).filter(m-> m.isAnnotationPresent(Init.class))
                .forEach(m-> {
                    m.setAccessible(true);
                    try {
                        m.invoke(objeto);
                    } catch (IllegalAccessException  | InvocationTargetException e) {
                        throw new JsonSerializadorException("Error con el objeto");
                    }
                });
    }
    public static String convertirJson(Object objeto){

        //es lo mismo que esta en el if Objects.isNull(objeto);
        if(objeto == null){
            throw new JsonSerializadorException("El objeto serializable no pude ser null");
        }
        inicializarObjeto(objeto);
        Field[] atributos = objeto.getClass().getDeclaredFields();

        return Arrays.stream(atributos)
                .filter(f-> f.isAnnotationPresent(JsonAtributo.class))
                .map(f -> {
                    f.setAccessible(true);
                    String nombre = f.getAnnotation(JsonAtributo.class).nombre().equals("")
                            ? f.getName()
                            : f.getAnnotation(JsonAtributo.class).nombre();
                    try {
                        Object valor = f.get(objeto);
                        if (f.getAnnotation(JsonAtributo.class)
                                .capitalizar() && valor instanceof String) {
                            String nuevoValor = (String) valor;
                            nuevoValor = Arrays.stream(nuevoValor.split(" "))
                                    .map(palabra -> palabra.substring(0,1).toUpperCase()
                                        + palabra.substring(1).toLowerCase())
                                            .collect(Collectors.joining(" "));
                            f.set(objeto,nuevoValor);
                        }
                        return "\"" + nombre + "\":\"" + f.get(objeto) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e.getMessage());
                    }
                })
                .reduce("{", (a,b) -> {
                    if("{".equals(a)){
                        return a+b;
                    }
                    return a+ ", "+b;
                }).concat("}");
    }
}
