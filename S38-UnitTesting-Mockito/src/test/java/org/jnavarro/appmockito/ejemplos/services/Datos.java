package org.jnavarro.appmockito.ejemplos.services;

import org.jnavarro.appmockito.ejemplos.models.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {
    public static final List<Examen> EXAMENES = Arrays.asList(
            new Examen(5L, "Matematicas"),
            new Examen(6L, "Lenguaje"),
            new Examen(7L, "Historia"));

    public static final List<String> PREGUNTAS = Arrays.asList(
            "ARITMETICA","INTEGRALES", "DERIVADAS","TRIGONOMETRIA","GEOMETRIA");

    public static final Examen  EXAMEN = new Examen(null, "Fisica");
}

