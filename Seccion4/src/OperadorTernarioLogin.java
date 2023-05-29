import java.util.Scanner;

public class OperadorTernarioLogin {

    public static void main(String[] args) {
        System.out.println("========================================================");

        String[] usernames = { "javier","admin","benzema"};
        String[] passwords = { "12345","12345","12345"};

        Scanner scanner = new Scanner(System.in);

        System.out.println("ingresa username");
        String user = scanner.next();

        System.out.println("ingresa pass");
        String pass = scanner.next();

        boolean esAutenticado = false;

        for (int i = 0; i < usernames.length; i++) {
            esAutenticado = (usernames[i].equals(user) && passwords[i].equals(pass))? true: esAutenticado;
        }
        
        String mensaje = esAutenticado ? "Bienvenido usuario ".concat(user) : "Lo sentimos, contraseña incorrecta.";
        System.out.println("mensaje = " + mensaje);

        /*
        if(esAutenticado){
            System.out.println("Autenticado correctamente");
        }else {
            System.out.println("error de autenticacion");
        }
        
         */
    }
}
