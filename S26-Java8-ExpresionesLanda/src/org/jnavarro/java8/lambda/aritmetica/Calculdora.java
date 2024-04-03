package org.jnavarro.java8.lambda.aritmetica;

import java.util.function.BiFunction;

public class Calculdora {
    public double computar(double a, double b, Aritmetica aritmetica){
        return aritmetica.operacion(a,b);
    }

    public double computarConBiFunction(double a, double b, BiFunction<Double,Double,Double> aritmetica){
        return aritmetica.apply(a,b);
    }
}
