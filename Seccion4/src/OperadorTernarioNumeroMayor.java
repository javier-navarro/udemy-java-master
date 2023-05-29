import java.util.Scanner;

public class OperadorTernarioNumeroMayor {
    public static void main(String[] args) {
        int max = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa numero1");
        int numero1 = scanner.nextInt();

        System.out.println("Ingresa numero2");
        int numero2 = scanner.nextInt();

        System.out.println("Ingresa numero3");
        int numero3 = scanner.nextInt();

        System.out.println("Ingresa numero4");
        int numero4 = scanner.nextInt();

        max = (numero1 > numero2)? numero1 : numero2;
        max = (max >numero3)? max : numero3;
        max = (max >numero4)? max : numero4;

        System.out.println("El numero mayor es = " + max);
    }
}
