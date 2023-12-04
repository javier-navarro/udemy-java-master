package org.jnavarro.poointerfaces.imprenta;

import org.jnavarro.poointerfaces.imprenta.modalo.*;

public class EjemploImprenta {
    public static void main(String[] args) {
        Curriculo cv = new Curriculo("Resumen laboral..",new Persona("Karim","Benzema" ),"Ingeniero en Informatica");
        cv.addExperiencia("java");
        cv.addExperiencia("angular");
        cv.addExperiencia("javascript");
        cv.addExperiencia("css");
        cv.addExperiencia("Fullstack");

        Informe informe = new Informe("Microservicios", new Persona("Cristiano","Ronaldo" ), "Guardiola");

        Libro libro = new Libro(new Persona("Stephen","King" ), "Los caminantes", Genero.TERROR);
        libro.addPagina(new Pagina("Terror maximo"))
                        .addPagina(new Pagina("pagina2"))
                        .addPagina(new Pagina("pagina3"));
        Imprimible.imprimir(cv);
        Imprimible.imprimir(informe);
        Imprimible.imprimir(libro);
    }

    /*public static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }*/
}
