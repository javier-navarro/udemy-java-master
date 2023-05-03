package Seccion2.src;

import java.util.Scanner;

public class DetalleDeFactura {

    /*
    * Se solicita desarrollar programa que reciba datos de la factura utilizando scanner--
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa nombre de la factura");
        String nombreFactura = scanner.nextLine();
        //System.out.println("nombreFactura = " + nombreFactura);

        System.out.println("Ingresa descripcion de la factura");
        String DescripcionFactura = scanner.nextLine();
        //System.out.println("DescripcionFactura = " + DescripcionFactura);

        System.out.println("Ingresa precio producto 1");
        double precioProducto1 = scanner.nextDouble();
        //System.out.println("precioProducto1 = " + precioProducto1);

        System.out.println("Ingresa precio producto 2");
        double precioProducto2 = scanner.nextDouble();
        //System.out.println("precioProducto2 = " + precioProducto2);

        System.out.println(calculaTotal(precioProducto1,precioProducto2,nombreFactura));
    }

    static String calculaTotal(double num1, double num2, String nombreFactura){
        String salida = "";
        double resultado = 0;
        double resultadoBruto = 0;
        double iva = 0;

        resultadoBruto = num1+num2;
        iva = (num1+num2)*0.19;
        resultado = resultadoBruto + iva;

        salida += "La factura " + nombreFactura ;
        salida += " tiene un total bruto de " + resultadoBruto;
        salida += " con un impuesto de " + iva;
        salida += " y el monto despues del impuesto es de " + resultado;
        return salida;
    }


}
