package Seccion9_ClaseSystem;
//Clase83
import java.util.Map;

public class EjemploVariablesEntorno {
    /*
    * Traemos informacion del sistema.
    * */
    public static void main(String[] args) {
        Map <String, String> varEnv = System.getenv();
        System.out.println("varEnv = " + varEnv);
        
        String username = System.getenv("USERNAME");
        System.out.println("username = " + username);
        
        String javaHome = System.getenv("JAVA_HOME");
        System.out.println("javaHome = " + javaHome);
        
        String tempDir = System.getenv("TMPDIR");
        System.out.println("tempDir = " + tempDir);
        
        String path = System.getenv("PATH");
        System.out.println("path = " + path);
    }
}

/*
* Clase 84
*
* System.exit(1): salida con error.
* system.errr = hace los mismo que el out pero marca con error
* System.gc(): para invocar al limpiador.
*
* */
