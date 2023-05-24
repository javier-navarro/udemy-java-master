import java.util.Scanner;

public class OperadorLogicoLogin {

    public static void main(String[] args) {
        System.out.println("========================================================");

        String username = "javier", password = "12345";
        String username2 = "admin", password2 = "admin";

        Scanner scanner = new Scanner(System.in);

        System.out.println("ingresa username");
        String user = scanner.next();

        System.out.println("ingresa pass");
        String pass = scanner.next();

        boolean esAutenticado = false;

        if((user.equals(username) && pass.equals(password)) || (user.equals(username2) && pass.equals(password2))){
            esAutenticado = true;
        }

        if(esAutenticado){
            System.out.println("Autenticado correctamente");
        }else {
            System.out.println("error de autenticacion");
        }
    }
}
