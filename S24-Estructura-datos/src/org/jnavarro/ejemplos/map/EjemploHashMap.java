package org.jnavarro.ejemplos.map;

import java.util.*;

public class EjemploHashMap {
    public static void main(String[] args) {
        //permite almacenar objetos de forma asociativa
        //trabaja llave , valor. la llave es unica.
        Map<String,String> persona = new HashMap<>();
        
        persona.put("nombre", "john");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "zero");
        persona.put("email", "john@gmail.com");
        persona.put("edad", "30");
        System.out.println("persona = " + persona);

        String nombre = persona.get("nombre");
        System.out.println("nombre = " + nombre);
        String apellido = persona.get("apellido");
        System.out.println("apellido = " + apellido);

        //Eliminar
        /*
        *   clear() -> eliminia todo
        *   remove() -> por llave o por llave y valor
        *   containsKey
        *   containsKey
        * */

        System.out.println("==========================================");
        System.out.println("============removoviendo==============================");
        String valorApellido =  persona.remove("apellidoPaterno");
        boolean b =  persona.remove("apellidoPaterno", "dzeko");

        System.out.println("boolean = " + b);
        System.out.println("eliminado = " + valorApellido);
        System.out.println("persona = " + persona);

        boolean b2 =  persona.containsKey("apellido");
        System.out.println("buscador = " + b2);

        b2 = persona.containsValue("30");
        System.out.println("buscador2 = " + b2);

        //retorna coleccion del tipo string
        Collection<String> valores = persona.values();
        for (String v: valores){
            System.out.println("valor = " + v);
        }

        //retorna las llaves
        Set<String> llaves = persona.keySet();
        for (String v: llaves){
            System.out.println("llave = " + v);
        }

        //iterar llave y valor
        System.out.println("===============entrySet===========================");
        for (Map.Entry<String,String> pares : persona.entrySet()){
            System.out.println(pares.getKey() + " => " + pares.getValue());
        }

        //segunda forma de recorrer
        System.out.println("===============keySet===========================");
        for (String llave: persona.keySet()){
            String valor = persona.get(llave);
            System.out.println(llave + " => " + valor);
        }

        //tercera forma de recorrer
        System.out.println("===============JAVA 8 FOREACH===========================");
        persona.forEach((llave, valor) ->{
            System.out.println(llave + " => " + valor);
        });

        System.out.println("total = " + persona.size());
        System.out.println("contiene elementos = " + !persona.isEmpty());

        System.out.println("===============reemplazo===========================");
        persona.replace("apellido", "de bruyne");
        System.out.println("persona = " + persona);
    }
}
