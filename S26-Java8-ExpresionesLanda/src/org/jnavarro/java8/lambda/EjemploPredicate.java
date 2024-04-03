package org.jnavarro.java8.lambda;

import org.jnavarro.java8.lambda.models.Usuario;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {
        //siempre retorna boolean
        //sirve para hacer comparaciones
        Predicate<Integer> test = num -> num>10;
        boolean resultado = test.test(11);
        System.out.println("resultado = " + resultado);

        Predicate<String> test2 = role -> role.equals("ROLE_ADMIN");
        System.out.println("test2.test(\"ROLE_ADMIN\") = " + test2.test("ROLE_ADMIN"));

        //acepta 2 parametros de entrada, son lo mismo
        //BiPredicate<String,String> test3 = (a,b) -> a.equals(b);
        BiPredicate<String,String> test3 = String::equals;
        System.out.println("test3.test(\"Hola\", \"Hola\") = " + test3.test("Hola", "Hola"));

        BiPredicate<Integer,Integer> test4 = (a,b) -> a > b;
        boolean resultado2 = test4.test(5,10);
        System.out.println("resultado2 = " + resultado2);

        Usuario a = new Usuario();
        Usuario b = new Usuario();

        a.setNombre("maria");
        b.setNombre("cata");

        //BiPredicate<Usuario,Usuario> test5 = (ua,ub) -> a.getNombre().equals(b.getNombre());
        BiPredicate<Usuario,Usuario> test5 = Objects::equals;
        System.out.println("test5.test(a,b) = " + test5.test(a,b));

        
    }
}
