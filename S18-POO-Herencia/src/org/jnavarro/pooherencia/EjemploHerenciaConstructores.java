package org.jnavarro.pooherencia;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class EjemploHerenciaConstructores {
    public static void main(String[] args) {
        Alumno alumno = new Alumno("javier","navarro",30,"Saleciano");
        alumno.setNotaHistoria(7);
        alumno.setNotaMatematicas(7);
        alumno.setNotaLenguaje(5);



        AlumnoInternacional alumnoInternacional = new AlumnoInternacional("Edin", "Dzeko");
        alumnoInternacional.setPais("Nueva Zelanda");
        alumnoInternacional.setNotaIdiomas(6);
        alumnoInternacional.setInstitucion("Nacional");
        alumnoInternacional.setNotaHistoria(5);
        alumnoInternacional.setNotaMatematicas(6);
        alumnoInternacional.setNotaLenguaje(7);
        alumnoInternacional.setEdad(23);

        Profesor profesor = new Profesor("Tito", "soto",40, "Matematicas");

        imprimir(alumno);
        imprimir(alumnoInternacional);
        imprimir(profesor);

    }

    public static void imprimir(Persona persona){
        System.out.println("nombre: " + persona.getNombre()
                +", apellido: "+persona.getApellido()
                +", edad: "+persona.getEdad()
                +", email: "+persona.getEmail());

        if(persona instanceof Alumno){
            System.out.println("Imprimiendo datos del tipo alumno");
            System.out.println("Institucion:  " + ((Alumno) persona).getInstitucion());
            System.out.println("Nota Matematicas:  " + ((Alumno) persona).getNotaMatematicas());
            System.out.println("Nota Lenguaje:  " + ((Alumno) persona).getNotaLenguaje());
            System.out.println("Nota Historia:  " + ((Alumno) persona).getNotaHistoria());
            if(persona instanceof AlumnoInternacional){
                System.out.println("Imprimiendo datos del tipo alumnoInternacional");
                System.out.println("pais:  " + ((AlumnoInternacional) persona).getPais());
                System.out.println("nota idiomas:  " + ((AlumnoInternacional) persona).getNotaIdiomas());
            }
        }
        if(persona instanceof Profesor){
            System.out.println("Imprimiendo datos del tipo Profesor");
            System.out.println("Asignatura: " + ((Profesor) persona).getAsignatura());
        }
        System.out.println("\n");
        System.out.println("=========================sobreescrito saludooo ===============================================");
        System.out.println("persona.saludar() = " + persona.saludar());

        System.out.println("========================================================================");

    }
}