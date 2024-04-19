package org.jnavarro.archivos.ejemplos;

import org.jnavarro.archivos.ejemplos.servicio.ArchivoServicio;

public class EjemploLeerArchivo {
    public static void main(String[] args) {
        ArchivoServicio servicio = new ArchivoServicio();
        System.out.println(servicio.leerArchivo2("D:\\WORK\\creandoArchivos\\java.txt"));
    }
}
