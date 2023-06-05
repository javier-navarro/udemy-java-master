package Seccion9_ClaseSystem;
//Clase 82.
import java.io.FileInputStream;
import java.util.Properties;

public class EjemploAsignarPropiedadesDeSistema {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("Seccion9_ClaseSystem/config2.properties");
            Properties p = new Properties(System.getProperties());
            p.load(fileInputStream);
            p.setProperty("mi.propiedad.personalidaza","Mi valor guardado es nuevo");

            System.setProperties(p);
            System.getProperties().list(System.out);
        } catch (Exception e) {
            System.err.println("No existe el archivo = " + e);


        }
    }
}
