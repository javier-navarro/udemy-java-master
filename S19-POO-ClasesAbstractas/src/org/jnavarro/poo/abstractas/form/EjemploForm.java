package org.jnavarro.poo.abstractas.form;

import org.jnavarro.poo.abstractas.form.elementos.ElementoForm;
import org.jnavarro.poo.abstractas.form.elementos.InputForm;
import org.jnavarro.poo.abstractas.form.elementos.SelectForm;
import org.jnavarro.poo.abstractas.form.elementos.TextAreaForm;
import org.jnavarro.poo.abstractas.form.elementos.select.Opcion;
import org.jnavarro.poo.abstractas.form.validador.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("password", "password");
        password.addValidador(new RequeridoValidador());
        password.addValidador(new LargoValidador(6,12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad");
        edad.addValidador(new NumeroValidador());

        TextAreaForm experiencia = new TextAreaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());

        Opcion java = new Opcion("1", "Java");
        lenguaje.addOpcion(java);
        lenguaje.addOpcion(new Opcion("2", "Python"));
        lenguaje.addOpcion(new Opcion("3", "Javascript"));
        lenguaje.addOpcion(new Opcion("4", "Typescript").setSelected());
        lenguaje.addOpcion(new Opcion("5", "PHP"));

        username.setValor("");
        password.setValor("123");
        email.setValor("javierbenzema@gmail.com");
        edad.setValor("28");
        experiencia.setValor("mas de 10 años en informatica desarrollando soluciones.");
        java.setSelected(true);

        List<ElementoForm> elementos = new ArrayList<>();
        elementos.add(username);
        elementos.add(password);
        elementos.add(email);
        elementos.add(edad);
        elementos.add(experiencia);
        elementos.add(lenguaje);

        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name=\" "+ this.nombre
                        + "\" value=\" "+ this.valor + " \">";
            }
        };
        saludar.setValor("Este campo esta deshabilitado");

        /* segunda forma */
        List<ElementoForm> elementos2 = Arrays.asList(username,password,email,edad,experiencia,lenguaje, saludar);

        for(ElementoForm e: elementos){
            System.out.println(e.dibujarHtml());
        }

        System.out.println("\n");

        /* segunda forma print*/
        elementos2.forEach(e -> {
            System.out.println(e.dibujarHtml());
        });

        elementos.forEach(e -> {
            if(!e.esValido()) {
                e.getErrores().forEach(err -> System.out.println(e.getNombre() + ": " + err));
            }
        });

    }
}