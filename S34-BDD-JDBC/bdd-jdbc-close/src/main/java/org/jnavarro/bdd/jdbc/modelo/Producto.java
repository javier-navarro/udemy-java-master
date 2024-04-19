package org.jnavarro.bdd.jdbc.modelo;

import java.util.Date;

public class Producto {
    private Long id;
    private String nombre;
    private Integer precio;
    private Date fechaRegitro;

    private Categoria categoria;

    public Producto() {
    }

    public Producto(Long id, String nombre, Integer precio, Date fechaRegitro) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaRegitro = fechaRegitro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Date getFechaRegitro() {
        return fechaRegitro;
    }

    public void setFechaRegitro(Date fechaRegitro) {
        this.fechaRegitro = fechaRegitro;
    }

    @Override
    public String toString() {
        return  id +
                "|" + nombre +
                "|" + precio +
                "|" + fechaRegitro +
                "|" + categoria.getNombre();
    }
}
