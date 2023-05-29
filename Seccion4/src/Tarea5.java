import java.util.Scanner;

public class Tarea5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la cantidad de litros ");
        int capacidadEstanque = scanner.nextInt();

        boolean lleno = capacidadEstanque >= 70 ? true: false;
        boolean casiLleno = capacidadEstanque >= 60 && capacidadEstanque < 70 ? true: false;
        boolean tresCuartos = capacidadEstanque >= 40 && capacidadEstanque < 60 ? true: false;
        boolean medio = capacidadEstanque >= 35 && capacidadEstanque < 35 ? true: false;
        boolean suficiente = capacidadEstanque >= 20 && capacidadEstanque < 35 ? true: false;
        boolean insuficiente = capacidadEstanque >= 1 && capacidadEstanque < 20 ? true: false;

        if (lleno){
            System.out.println("Estanque LLeno = " + suficiente);
            System.exit(0);
        }
        if (casiLleno){
            System.out.println("Estanque casiLleno = " + casiLleno);
            System.exit(0);
        }
        if (tresCuartos){
            System.out.println("Estanque tresCuartos = " + tresCuartos);
            System.exit(0);
        }
        if (medio){
            System.out.println("Estanque medio = " + medio);
            System.exit(0);
        }
        if (suficiente){
            System.out.println("Estanque suficiente = " + suficiente);
            System.exit(0);
        }
        if (insuficiente){
            System.out.println("Estanque insuficiente = " + insuficiente);
            System.exit(0);
        }
    }
}
