package org.jnavarro.tarea.model;

import java.util.Date;
import java.util.Objects;

public class Vuelo implements Comparable<Vuelo>{
    public String nombre;
    public String origen;
    public String destino;
    public String fechaLlegada;
    public Integer cantidadPasajeros;

    public Vuelo(String nombre, String origen, String destino, String fechaLlegada, int cantidadPasajeros) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.fechaLlegada = fechaLlegada;
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public Vuelo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vuelo vuelo = (Vuelo) o;
        return cantidadPasajeros == vuelo.cantidadPasajeros && Objects.equals(nombre, vuelo.nombre) && Objects.equals(origen, vuelo.origen) && Objects.equals(destino, vuelo.destino) && Objects.equals(fechaLlegada, vuelo.fechaLlegada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, origen, destino, fechaLlegada, cantidadPasajeros);
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "nombre='" + nombre + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", fechaLlegada=" + fechaLlegada +
                ", cantidadPasajeros=" + cantidadPasajeros +
                '}';
    }

    public int compareTo(Vuelo vuelo){
        return this.fechaLlegada.compareTo(vuelo.fechaLlegada);
    }
}
