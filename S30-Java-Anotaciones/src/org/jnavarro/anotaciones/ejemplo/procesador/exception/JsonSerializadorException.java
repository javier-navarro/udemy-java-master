package org.jnavarro.anotaciones.ejemplo.procesador.exception;

public class JsonSerializadorException extends RuntimeException {
    public JsonSerializadorException(String mensaje){
        super(mensaje);
    }
}
