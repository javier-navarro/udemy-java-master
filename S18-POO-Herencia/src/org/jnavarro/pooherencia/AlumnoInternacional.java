package org.jnavarro.pooherencia;

public class AlumnoInternacional extends Alumno{
    private String pais;
    private double notaIdiomas;

    public AlumnoInternacional(){
    }

    public AlumnoInternacional(String nombre, String apellido){
        super(nombre,apellido);
    }
    public AlumnoInternacional(String pais, double notaIdiomas) {
        this.pais = pais;
        this.notaIdiomas = notaIdiomas;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getNotaIdiomas() {
        return notaIdiomas;
    }

    public void setNotaIdiomas(double notaIdiomas) {
        this.notaIdiomas = notaIdiomas;
    }

    @Override
    public String saludar(){
        return "Hola que tal, soy un alumno internacional y mi nombre es: "+ getNombre();
    }
}
