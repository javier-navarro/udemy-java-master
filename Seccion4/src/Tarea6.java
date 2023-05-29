import javax.swing.*;

public class Tarea6 {
    public static void main(String[] args) {

        String nombre1 = JOptionPane.showInputDialog(null, "ingrese nombre completo persona1");
        String nombreDePila1 = nombre1.substring(0,nombre1.indexOf(" "));
        
        String nombre2 = JOptionPane.showInputDialog(null, "ingrese nombre completo persona2");
        String nombreDePila2 = nombre2.substring(0,nombre2.indexOf(" "));

        String nombre3 = JOptionPane.showInputDialog(null, "ingrese nombre completo persona3");
        String nombreDePila3 = nombre3.substring(0,nombre3.indexOf(" "));

        boolean nombreMasLargo = nombre1.length() > nombre2.length()? true : false;

        if(nombreMasLargo){
            nombreMasLargo = nombre1.length() > nombre3.length()? true: false;
            if(nombreMasLargo){
                System.out.println(nombreDePila1 + " tiene el nombre más largo.");
                System.exit(0);
            }else{
                System.out.println(nombreDePila3 + " tiene el nombre más largo.");
                System.exit(0);
            }
        }else{
            nombreMasLargo = nombre2.length() > nombre3.length()? true: false;
            if(nombreMasLargo){
                System.out.println(nombreDePila2 + " tiene el nombre más largo.");
                System.exit(0);
            }else{
                System.out.println(nombreDePila3 + " tiene el nombre más largo.");
                System.exit(0);
            }
        }

    }
}
