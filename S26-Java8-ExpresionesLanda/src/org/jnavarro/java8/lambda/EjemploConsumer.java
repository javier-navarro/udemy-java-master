package org.jnavarro.java8.lambda;

import org.jnavarro.java8.lambda.models.Usuario;

import java.sql.Struct;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {

        /*
        CONSUMER
        EXPRESION QUE NOS PERMITE PASAR UN ARGUMENTO DEL TIPO GENERICO, ES VOID
        eso es lo mismo que
        saludo -> {
            System.out.println(saludo);
        }

        saludo -> System.out.println(saludo);

         */
        Consumer<Date> consumer = fecha -> {
            SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
            System.out.println(f.format(fecha));
        };
        consumer.accept((new Date())); // ahi se asigna .

        //tiene 2 parametros, cuando tiene mas de 1 parametro, estos deben ir en parentesis
        BiConsumer<String,Integer> consumer1 = (a,b) -> System.out.println(a+" ,tiene "+ b+ " años");
        consumer1.accept("Eren",20);

        //estas 2 lineas son lo mismo pero sinplificado
        //Consumer <String> consumer2 = mensaje -> System.out.println(mensaje);
        Consumer <String> consumer2 = System.out::println;
        consumer2.accept("Hola shinganchina");

        //lista con foreach
        List <String> nombres = Arrays.asList("Eren","Mikasa","Tengen", "Armin");
        nombres.forEach(consumer2);

        Supplier<Usuario> creaUsuario = Usuario::new;
        Usuario usuario = creaUsuario.get();
        //significan lo mismo
        /*
        BiConsumer<Usuario, String> asignarNombre = (a,b) -> {
            a.setNombre(b);
        };
         */
        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre;
        asignarNombre.accept(usuario,"tokito");
        System.out.println("nombre usuario: "+usuario.getNombre());

        //Supplier : solo retorna valor.
        //las 2 formas hacen los mismo
        /*
        Supplier<String> proveedor = () -> {
            return "hola taicho";
        };
         */
        Supplier<String> proveedor = () -> "hola taicho";
        System.out.println(proveedor.get());
    }
}
