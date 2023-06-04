import java.util.Scanner;

public class SentenciaSwitchCase {
    public static void main(String[] args) {

        int numero = 10;
        switch (numero){
            case 0:
                System.out.println("el numero es 0");
                break;
            case 1:
                System.out.println("el numero es 1");
                break;
            case 2:
                System.out.println("el numero es 2");
                break;
            case 3:
                System.out.println("el numero es 3");
                break;
            default:
                System.out.println("no aplica");
        }

        String nombre = "cristiano";
        switch (nombre){
            case "admin":
                System.out.println("Bienvenido admin");
                break;
            case "benzema":
                System.out.println("Bienvenido Benzema");
                break;
            case "cristiano":
                System.out.println("Bienvenido CR7");
                break;
            default:
                System.out.println("ninguna de las opciones elegidas");
        }

        String nombreMes = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa mes a buscar");
        int mes = scanner.nextInt();

        switch (mes){
            case 1:
                nombreMes = "Enero";
                break;
            case 2:
                nombreMes = "Febrero";
                break;
            case 3:
                nombreMes = "Marzo";
                break;
            case 4:
                nombreMes = "Abril";
                break;
            case 5:
                nombreMes = "Mayo";
                break;
            case 6:
                nombreMes = "Junio";
                break;
            case 7:
                nombreMes = "Julio";
                break;
            case 8:
                nombreMes = "Agosto";
                break;
            case 9:
                nombreMes = "Septiembre";
                break;
            case 10:
                nombreMes = "Octubre";
                break;
            case 11:
                nombreMes = "Noviembre";
                break;
            case 12:
                nombreMes = "Diciembre";
                break;
            default:
                System.out.println("undefined");
        }

        System.out.println("nombreMes = " + nombreMes);



    }
}
