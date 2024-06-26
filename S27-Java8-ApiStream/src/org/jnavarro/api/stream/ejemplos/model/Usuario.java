package org.jnavarro.api.stream.ejemplos.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private String nombre, apellido;
    private Integer id;
    private static int ultimoId;

    private List<Factura> facturas;

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = ++ultimoId;
        this.facturas = new ArrayList<>();
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void addFacturas(Factura facturas) {

        this.facturas.add(facturas);
        facturas.setUsuario(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static int getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(int ultimoId) {
        Usuario.ultimoId = ultimoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return id+ " - "+nombre+" "+apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) && Objects.equals(apellido, usuario.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }
}
