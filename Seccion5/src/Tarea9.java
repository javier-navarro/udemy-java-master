import java.util.Scanner;

public class Tarea9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int resultado = 0;

        System.out.println("Ingresa numero 1 ");
        int numero1 = scanner.nextInt();

        System.out.println("Ingresa numero 2 ");
        int numero2 = scanner.nextInt();

        for (int i = 0; i < numero2 ; i++) {
            resultado +=  numero1;
        }
        System.out.println(resultado);



    }
}
