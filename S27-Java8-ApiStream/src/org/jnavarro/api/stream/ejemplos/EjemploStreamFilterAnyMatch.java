package org.jnavarro.api.stream.ejemplos;

import org.jnavarro.api.stream.ejemplos.model.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
* anyMatch: return boolean
*   recorre la lista, y al encontrar el valor sale y devuelve true
*   si no encuentra nada, recorre la lista y devuelve false
* */
public class EjemploStreamFilterAnyMatch {
    public static void main(String[] args) {
       boolean existe  = Stream
                .of("mikasa ackerman","armin arlet","Eren Jaeger", "Yan Sho", "Sasha grey")
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
               .peek(System.out::println)
               .anyMatch(u -> u.getId().equals(3));

        System.out.println("existe = " + existe);

        List<Usuario> listaUsuario = Arrays.asList(new Usuario("mikasa", "ackerman"),new Usuario("Eren", "Jaeger"));
        System.out.println("listaUsuario.size() = " + listaUsuario.size());
        boolean resultado =false;
        for (Usuario usuario: listaUsuario){
            System.out.println("usuario = " + usuario);
            if(usuario.getId().equals(5)){
                resultado = true;
                break;
            }
            System.out.println("resultado = " + resultado);
        }

    }
}
