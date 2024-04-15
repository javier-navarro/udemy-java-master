package org.jnavarro.patrones.composite;

public class EjemploCompositeBuscar {
    public static void main(String[] args) {
        Directorio directorio = new Directorio("Documentos");
        Directorio java = new Directorio("Java");

        java.addComponente(new Archivo("patron-1"));
        Directorio stream = new Directorio("Api Stream");
        stream.addComponente(new Archivo("Stream-map.doc"));

        java.addComponente(stream);

        directorio.addComponente(java);
        directorio.addComponente(new Archivo("cv.doc"));
        directorio.addComponente(new Archivo("logo.doc"));

        boolean encontrado = directorio.buscar("patron-1");
        System.out.println("encontrado = " + encontrado);
    }
}
