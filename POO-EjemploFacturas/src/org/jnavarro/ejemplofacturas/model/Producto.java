package org.jnavarro.ejemplofacturas.model;

public class Producto {
    private Integer codigo;
    private String nombre;
    private double precio;
    private static  int ultimoCodigo;
    public Producto() {
        this.codigo = ++ultimoCodigo;
    }

    public Producto(Integer codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
