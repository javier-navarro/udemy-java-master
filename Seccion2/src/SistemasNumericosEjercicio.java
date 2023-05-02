package Seccion2.src;

import javax.swing.*;

public class SistemasNumericosEjercicio {
    public static void main(String[] args) {

        String numeroString = JOptionPane.showInputDialog(null, "ingrese un numero entero");
        int numeroDecimal = 0;
        try {
            numeroDecimal = Integer.parseInt(numeroString);
            System.out.println("numeroDecimal = " + numeroDecimal);

            System.out.println("numero binario de "+numeroDecimal + "=" + Integer.toBinaryString(numeroDecimal));
        } catch(NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "debe ingresar un numero entero");
            main(args);
            System.exit(0);
        }



        int numeroBinario = Integer.parseInt(Integer.toBinaryString(numeroDecimal));
        System.out.println("numeroBinario = " + numeroBinario);
        System.out.println("numero octal de "+numeroBinario + " = " + Integer.toOctalString(numeroDecimal));

        int numeroOctal = Integer.parseInt(Integer.toOctalString(numeroDecimal));
        System.out.println("numeroOctal = " + numeroOctal);

        System.out.println("numero hexadecimal de "+numeroDecimal + " = " + Integer.toHexString(numeroDecimal));
        String hexaformateado = "0x"+Integer.toHexString(numeroDecimal);
        System.out.println(hexaformateado);
        int numeroHex = Integer.parseInt(hexaformateado);
        System.out.println("numeroHex = " + numeroHex);

        String mensaje = "Numero binario de "+ numeroDecimal +" = " + Integer.toBinaryString(numeroDecimal);
        mensaje += "\nNumero octal de "+numeroBinario + " = " + Integer.toOctalString(numeroDecimal);
        mensaje += "\nNumero hexadecimal de "+numeroDecimal + " = " + Integer.toHexString(numeroDecimal);
        JOptionPane.showMessageDialog(null, mensaje);
    }
}

