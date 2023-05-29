import java.util.Scanner;

public class Tarea4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa numero 1");
        int numero1 = scanner.nextInt();

        System.out.println("Ingresa numero 2");
        int numero2 = scanner.nextInt();

        boolean numeroMayor = numero1 > numero2 ? true: false;

        boolean sonIguales = numero1 == numero2 ? true: false;

        if(sonIguales){
            System.out.println("los numeros son iguales.");
        }else {
            if(!numeroMayor){
                System.out.println("numeroMayor = " + numero2);
                System.out.println("numeroMenor = " + numero1);
            }else {
                System.out.println("numeroMayor = " + numero1);
                System.out.println("numeroMenor = " + numero2);
            }
        }




    }
}
