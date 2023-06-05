package Seccion9_ClaseSystem;

import java.io.IOException;

//Clase 85
public class EjemploEjecutarProgramaSO {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        Process proceso;

        System.out.println("System.getProperties() = " + System.getProperties());
            try {
                if(System.getProperty("os.name").startsWith("Mac")) {
                    proceso = rt.exec("TextEdit.app");
                }else if(System.getProperty("os_name").startsWith("Apple")){
                    proceso = rt.exec("notepadd");
                }else{
                    proceso = rt.exec("gedit");
                }
            } catch (IOException e) {
                System.err.println("el comando es desconocido: "+ e.getMessage());
                System.exit(1);
            }
        System.out.println("se ha cerrado el editor");
        System.exit(0);
    }
}
