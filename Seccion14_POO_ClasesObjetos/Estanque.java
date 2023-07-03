package Seccion14_POO_ClasesObjetos;

public class Estanque {
    private int capacidad;

    public Estanque() {
        this.capacidad = 40;
    }
    public Estanque(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
