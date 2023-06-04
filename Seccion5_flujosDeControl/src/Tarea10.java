import java.util.Scanner;

public class Tarea10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
        actualizar, eliminar, crear, listar y salir.
         */
        System.out.println("Seleccione Menu");
        System.out.println("1- Actualizar");
        System.out.println("2- Eliminar");
        System.out.println("3- Agregar");
        System.out.println("4- Listar");
        System.out.println("5- Salir");
        System.out.println("\n");
        int opcion = scanner.nextInt();

        if( opcion > 5 || opcion <= 0){
            System.out.println("Debes seleccionar una opcion valida");
            main(args);
        }else {
            switch (opcion){
                case 1:
                    System.out.println("Usuario actualizado correctamente");
                    break;
                case 2:
                    System.out.println("Usuario eliminado correctamente");
                    break;
                case 3:
                    System.out.println("Usuario agregado correctamente");
                    break;
                case 4:
                    System.out.println("Mostrando lista de usuarios...");
                    break;
                case 5:
                    System.out.println("Haz salido con exito!");
                    break;
            }
        }

    }
}
