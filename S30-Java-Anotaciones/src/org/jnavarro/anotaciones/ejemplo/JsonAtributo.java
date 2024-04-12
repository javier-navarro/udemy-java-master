package org.jnavarro.anotaciones.ejemplo;

import java.lang.annotation.*;

// spring, hibernate, ocupan bastante anotaciones
/*
*   @Inherited //para herencia
* */
@Target(ElementType.FIELD)  //Target: objetivo sobre el cual se implementara
@Retention(RetentionPolicy.RUNTIME)  //tiempo de ejecucion (runtime), o de compilacion (class)
@Documented //para agregarlo al javadoc


public @interface JsonAtributo {
    String nombre() default "";
    boolean capitalizar() default false;
}
