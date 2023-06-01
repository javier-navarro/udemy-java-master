import java.util.Arrays;
import java.util.Scanner;

public class Tarea8 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Double arrayNotas[] = new Double[20];

        double promedioTotal = 0;
        double promedioMayor5 = 0;
        double promedioRojos = 0;
        double sumaRojos = 0;
        double sumaMayor5 = 0;
        int contador1 = 0;
        int contadorRojos = 0;
        int contadorMayor5 = 0;


        for (int i = 0; i <= arrayNotas.length-1; i++) {
            System.out.println("INTRODUCE NOTA " + (i+1));
            arrayNotas[i] = scanner.nextDouble();

            if(arrayNotas[i] == 0 || arrayNotas[i] > 7){
                System.out.println("Nota invalida");
                System.exit(0);
            }
        }
        System.out.println("arrayNumeros = " + Arrays.toString(arrayNotas));
        System.out.println("\n");


        for (int i = 0; i <= arrayNotas.length-1; i++) {
            //promedio total
            promedioTotal += (arrayNotas[i])/ arrayNotas.length;

            //contador de 1
            if(arrayNotas[i] == 1){
                contador1++;
            }
            //promedio notas rojas
            if(arrayNotas[i] < 4){
                contadorRojos++;
                sumaRojos += arrayNotas[i];
            }
            promedioRojos = (sumaRojos / contadorRojos) ;

            if(arrayNotas[i] > 5){
                contadorMayor5++;
                sumaMayor5 += arrayNotas[i];
            }
            promedioMayor5 = (sumaMayor5 / contadorMayor5) ;

        }
        System.out.println("promedioMayor5 = " + promedioMayor5);
        System.out.println("promedioRojos = " + promedioRojos);
        System.out.println("promedioTotal = " + promedioTotal);
        System.out.println("contador1 = " + contador1);



        //promedio notas mayores a 5
        //promedio notas inferiores a 4
        // count notas 1
        // promedio total.

    }
}
