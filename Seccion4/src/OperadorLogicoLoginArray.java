import java.util.Scanner;

public class OperadorLogicoLoginArray {

    public static void main(String[] args) {
        System.out.println("========================================================");

        /*
        String[] usernames = new String[3];
        String[] passwords = new String[3];

        usernames[0] = "javier";
        usernames[1] = "admin";
        usernames[2] = "benzema";

        passwords[0] = "12345";
        passwords[1] = "12345";
        passwords[2] = "12345";

         */
        //tambien se pueden definir asi los arrays

        String[] usernames = { "javier","admin","benzema"};
        String[] passwords = { "12345","12345","12345"};

        Scanner scanner = new Scanner(System.in);

        System.out.println("ingresa username");
        String user = scanner.next();

        System.out.println("ingresa pass");
        String pass = scanner.next();

        boolean esAutenticado = false;

        for (int i = 0; i < usernames.length; i++) {
            if((usernames[i].equals(user) && passwords[i].equals(pass)) ){
                esAutenticado = true;
                break;
            }
        }

        if(esAutenticado){
            System.out.println("Autenticado correctamente");
        }else {
            System.out.println("error de autenticacion");
        }
    }
}
