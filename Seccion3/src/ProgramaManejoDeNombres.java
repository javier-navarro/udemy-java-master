import java.util.Scanner;

public class ProgramaManejoDeNombres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa primer nombre");
        String nombre1 = scanner.nextLine();
        int largoNombre1 = nombre1.length();
        String letraNombre1 = String.valueOf(nombre1.charAt(1)) ;
        String finalNombre1 = nombre1.substring(largoNombre1-2, largoNombre1);

        String nombre1Modificado = letraNombre1.toUpperCase().concat(".").concat(finalNombre1);

        System.out.println("Ingresa segundo nombre");
        String nombre2 = scanner.nextLine();
        int largoNombre2 = nombre2.length();
        String letraNombre2 = String.valueOf(nombre2.charAt(1)) ;
        String finalNombre2 = nombre2.substring(largoNombre2-2, largoNombre2);
        String nombre2Modificado = letraNombre2.toUpperCase().concat(".").concat(finalNombre2);

        System.out.println("Ingresa tercero nombre");
        String nombre3 = scanner.nextLine();
        int largoNombre3 = nombre3.length();
        String letraNombre3 = String.valueOf(nombre3.charAt(1)) ;
        String finalNombre3 = nombre3.substring(largoNombre3-2, largoNombre3);
        String nombre3Modificado = letraNombre3.toUpperCase().concat(".").concat(finalNombre3);

        String salidaConsulta = nombre1Modificado.concat("_").concat(nombre2Modificado).concat("_").concat(nombre3Modificado);
        System.out.println("salidaConsulta = " + salidaConsulta);

    }
}
