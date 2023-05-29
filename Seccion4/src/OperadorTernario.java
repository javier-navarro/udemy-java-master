import java.util.Scanner;

public class OperadorTernario {
    public static void main(String[] args) {
        System.out.println("========================================================");

        //variable = condicion ? si es verdadero : si es falso;
        String variable = 7 == 7 ? "si es verdadero" : "es falsa la wea";
        System.out.println("variable = " + variable);

        String estado = "";
        double promedio = 0.0;

        double nota1 = 0.0;
        double nota2 = 0.0;
        double nota3 = 0.0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("ingresa la nota 1");
        nota1 = scanner.nextDouble();

        System.out.println("ingresa la nota 2");
        nota2 = scanner.nextDouble();

        System.out.println("ingresa la nota 3");
        nota3 = scanner.nextDouble();

        promedio = (nota1 + nota2 + nota3)/3;
        
        estado = promedio >= 5.49 ? "Aprobado" : "Rechazado";
        System.out.println("promedio = " + promedio);
        System.out.println("estado = " + estado);
    }
}
