import java.util.Arrays;
import java.util.Scanner;

public class Tarea7 {
    public static void main(String[] args) {
        int arrayNumeros[] = new int[10];
        int menor;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i <= arrayNumeros.length-1; i++) {
            System.out.println("INTRODUCE NUMERO " + (i+1));
            arrayNumeros[i] = scanner.nextInt();
        }
        System.out.println('\n');
        System.out.println("arrayNumeros = " + Arrays.toString(arrayNumeros));

        menor = arrayNumeros[0];
        for (int i = 0; i <= arrayNumeros.length-2; i++) {

            if (menor > arrayNumeros[i+1]){
                menor = arrayNumeros[i+1];
            }
            //System.out.println("numero menor = " + menor);
            if (i == arrayNumeros.length-2){
                if(menor < 10){
                    System.out.println("El numero menor es menor que 10");
                }else {
                    System.out.println("El numero menor es igual o mayor que 10!");
                }
            }
        }

    }
}
