import javax.swing.*;

public class OperadorAritmetico {

    public static void main(String[] args) {
        int i= 5,j = 4;
        int suma = i + j, resta = i -j, multiplicacion = i * j, division = i / j;
        int resto = i % j;
        float division2 = (float)i / (float)j;
        System.out.println("========================================================");
        System.out.println("suma = " + suma);
        System.out.println("i + j = "+ i + j);
        System.out.println("(i + j) = "+ (i + j));
        System.out.println("resta = " + resta);
        System.out.println("multiplicacion = " + multiplicacion);
        System.out.println("division = " + division);
        System.out.println("division2 = " + division2);
        System.out.println("resto = " + resto);
        resto = 8 % 5;
        System.out.println("resto = " + resto);

        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un numero"));
        if (numero % 2 == 0){
            System.out.println("numero par = " + numero);
        }else {
            System.out.println("numero impar = " + numero);
        }
    }
}
