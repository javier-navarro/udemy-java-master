package org.jnavarro.pooherencia;

public class Profesor extends  Persona{
    private String asignatura;

    public Profesor(){

    }

    public Profesor(String nombre, String apellido, int edad, String asignatura) {
        super(nombre, apellido, edad);
        this.asignatura = asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String saludar() {
        return "Buenos dias soy el profe de: "+ getAsignatura();
    }
}
