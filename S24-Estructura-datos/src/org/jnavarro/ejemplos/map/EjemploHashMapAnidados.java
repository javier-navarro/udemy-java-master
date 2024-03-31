package org.jnavarro.ejemplos.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EjemploHashMapAnidados {
    public static void main(String[] args) {
        //permite almacenar objetos de forma asociativa
        //trabaja llave , valor. la llave es unica.
        Map<String,Object> persona = new HashMap<>();
        
        persona.put("nombre", "john");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "zero");
        persona.put("email", "john@gmail.com");
        persona.put("edad", "30");
        System.out.println("persona = " + persona);

        Map<String,String> direccion = new HashMap<>();
        direccion.put("pais", "usa");
        direccion.put("estado", "california");
        direccion.put("ciudad", "Santa barbara");
        direccion.put("calle", "one street");
        direccion.put("numero", "120");

        persona.put("direccion",direccion);


        String nombre = (String) persona.get("nombre");
        System.out.println("nombre = " + nombre);
        String apellido = (String) persona.get("apellido");
        System.out.println("apellido = " + apellido);

        System.out.println("==========================================");
        Map<String,String> direccionPersona = (Map<String, String>) persona.get("direccion");
        String pais = direccionPersona.get("pais");
        String ciudad = direccionPersona.get("ciudad");
        String barrio = direccionPersona.getOrDefault("barrio", "la playa");
        System.out.println("direccionPersona = " + direccionPersona);
        System.out.println("pais = " + pais);
        System.out.println("ciudad = " + ciudad);
        System.out.println("barrio = " + barrio);

        //Eliminar
        /*
        *   clear() -> eliminia todo
        *   remove() -> por llave o por llave y valor
        *   containsKey
        *   containsKey
        * */

        System.out.println("==========================================");
        System.out.println("============removoviendo==============================");
        //Object valorApellido =  persona.remove("apellidoPaterno");
        boolean b =  persona.remove("apellidoPaterno", "dzeko");

        System.out.println("boolean = " + b);
        //System.out.println("eliminado = " + valorApellido);
        System.out.println("persona = " + persona);

        boolean b2 =  persona.containsKey("apellido");
        System.out.println("buscador = " + b2);

        b2 = persona.containsValue("30");
        System.out.println("buscador2 = " + b2);

        //retorna coleccion del tipo string
        Collection<Object> valores = persona.values();
        for (Object v: valores){
            System.out.println("valor = " + v);
        }

        //retorna las llaves
        Set<String> llaves = persona.keySet();
        for (String v: llaves){
            System.out.println("llave = " + v);
        }

        //iterar llave y valor
        System.out.println("===============entrySet===========================");
        for (Map.Entry<String,Object> pares : persona.entrySet()){
            System.out.println(pares.getKey() + " => " + pares.getValue());
        }

        //segunda forma de recorrer
        System.out.println("===============keySet===========================");
        for (String llave: persona.keySet()){
            Object valor = persona.get(llave);
            if(valor instanceof Map){
                String nom = (String) persona.get("nombre");
                Map<String,String> direccionMap = (Map<String, String>) valor;
                System.out.println("El pais de " + nom +": " + direccionMap.get("pais"));
                System.out.println("La ciudad de " + nom +": "+ direccionMap.get("ciudad"));
                System.out.println("La estado de " + nom +": "+ direccionMap.get("estado"));
            }else{
                System.out.println(llave + " => " + valor);
            }

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
