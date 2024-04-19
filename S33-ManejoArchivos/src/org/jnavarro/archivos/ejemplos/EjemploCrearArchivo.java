package org.jnavarro.archivos.ejemplos;

import org.jnavarro.archivos.ejemplos.servicio.ArchivoServicio;
/*
    Si la ruta no existe, la creacion del archivo falla
 */
public class EjemploCrearArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "D:\\WORK\\creandoArchivos\\java.txt";
        ArchivoServicio service = new ArchivoServicio();
        //service.crearArchivo(nombreArchivo);
        service.crearArchivo3(nombreArchivo);
    }
}
