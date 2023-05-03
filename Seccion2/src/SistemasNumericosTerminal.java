package Seccion2.src;

import java.util.Scanner;

public class SistemasNumericosTerminal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa un numero entero");
        //String numeroStr = scanner.nextLine();
        int numeroDecimal = 0;
        try {
            //numeroDecimal = Integer.parseInt(numeroStr);
            numeroDecimal = scanner.nextInt();
        }catch(Exception e){
            System.out.println("debes ingresar un valor valido.");
            main(args);
            System.exit(0);
        }

        System.out.println("numeroDecimal = " + numeroDecimal);

        String resultadoBinario = "numero binario de "+numeroDecimal+ " = "+Integer.toBinaryString(numeroDecimal);
        String resultadoOctal = "numero octal de "+numeroDecimal+ " = "+Integer.toOctalString(numeroDecimal);
        String resultadoHexa = "numero hexadecimal de "+numeroDecimal+ " = "+Integer.toHexString(numeroDecimal);

        String mensaje = resultadoBinario;
        mensaje += "\n" + resultadoOctal;
        mensaje += "\n" + resultadoHexa;
        System.out.println(mensaje);
    }
}
