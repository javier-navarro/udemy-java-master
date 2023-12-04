package org.jnavarro.pooherencia;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class EjemploHerencia {
    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        alumno.setNombre("javier");
        alumno.setApellido("navarro");
        alumno.setInstitucion("Saleciano");
        alumno.setNotaHistoria(7);
        alumno.setNotaMatematicas(7);
        alumno.setNotaLenguaje(5);

        Profesor profesor = new Profesor();
        profesor.setNombre("Julio");
        profesor.setApellido("Maldonado");
        profesor.setAsignatura("Matematicas");

        AlumnoInternacional alumnoInternacional = new AlumnoInternacional();
        alumnoInternacional.setNombre("Edin");
        alumnoInternacional.setApellido("Dzeko");
        alumnoInternacional.setPais("Nueva Zelanda");
        alumnoInternacional.setNotaIdiomas(6);
        alumnoInternacional.setInstitucion("Nacional");
        alumnoInternacional.setNotaHistoria(5);
        alumnoInternacional.setNotaMatematicas(6);
        alumnoInternacional.setNotaLenguaje(7);
        alumnoInternacional.setEdad(23);

        System.out.println(alumno.getNombre() +" "+alumno.getApellido());
        System.out.println(profesor.getAsignatura()+" "+profesor.getNombre() +" "+profesor.getApellido());
        System.out.println(alumnoInternacional.getPais()+" "+alumnoInternacional.getNombre() +" "+alumnoInternacional.getApellido());

        Class clase = alumnoInternacional.getClass();

        while(clase.getSuperclass() != null){
            String hija = clase.getName();
            String padre = clase.getSuperclass().getName();
            System.out.println(hija+ " es una clase hija de la clase: "+ padre);
            clase = clase.getSuperclass();
        }



    }
}