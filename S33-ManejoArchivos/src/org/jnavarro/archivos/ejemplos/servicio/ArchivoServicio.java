package org.jnavarro.archivos.ejemplos.servicio;

import java.io.*;
import java.util.Scanner;

public class ArchivoServicio {
    public void crearArchivo(String nombre) {
        File archivo = new File(nombre);
        try {
            FileWriter escritor = new FileWriter(archivo, true); //crea el archivo, el segundo parametro hace que se siga escribiendo el texto
            BufferedWriter buffer = new BufferedWriter(escritor);
            buffer.append("Hola los maquinas\n")
                    .append("como les va?\n");
            buffer.close();
            System.out.println("Archivo creado con exito....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearArchivo2(String nombre) {
        File archivo = new File(nombre);
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo, true))) {
            buffer.append("Hola los maquinas\n")
                    .append("como les va?\n");
            //buffer.close(); //no es necesario
            System.out.println("Archivo creado con exito....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearArchivo3(String nombre) {
        File archivo = new File(nombre);
        try (PrintWriter buffer = new PrintWriter(new FileWriter(archivo, true))) {
            buffer.println("Hola los maquinas\n");
            buffer.println("como les va?\n");
            buffer.println("Hoy gana colocolo\n");
            //buffer.close(); //no es necesario
            System.out.println("Archivo creado con exito....");
        } catch (IOException e) {
            System.out.println("ERROR AL CREAR ARCHIVO......");
            e.printStackTrace();
        }
    }

    public String leerArchivo(String nombre){
        StringBuilder stringBuilder  = new StringBuilder();
        File archivo = new File(nombre);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = reader.readLine()) != null){
                stringBuilder.append(linea).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public String leerArchivo2(String nombre){
        StringBuilder stringBuilder  = new StringBuilder();
        File archivo = new File(nombre);
        try {
            Scanner scanner = new Scanner(archivo);
            scanner.useDelimiter("\n"); //para delimitar el separador.
            while (scanner.hasNext()){
                stringBuilder.append(scanner.next()).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
