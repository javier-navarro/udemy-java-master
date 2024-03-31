
package org.jnavarro.ejemplos.map;

import java.util.*;

public class EjemploTreeMap {
    public static void main(String[] args) {

        //opcion1
        //Map<String,Object> persona = new TreeMap<>((a,b) -> b.compareTo(a));
        //opcion2 al reverso
        Map<String,Object> persona = new TreeMap<>(Comparator.reverseOrder());

        persona.put("nombre", "john");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "zero");
        persona.put("email", "john@gmail.com");
        persona.put("edad", "30");
        System.out.println("persona = " + persona);

        Map<String,String> direccion = new TreeMap<>();
        direccion.put("pais", "usa");
        direccion.put("estado", "california");
        direccion.put("ciudad", "Santa barbara");
        direccion.put("calle", "one street");
        direccion.put("numero", "120");

        persona.put("direccion",direccion);

        System.out.println("persona = " + persona);



    }
}

