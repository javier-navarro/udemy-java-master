package Seccion10_ClaseMath;

import java.util.Scanner;

/*
    area = PI*r² (Constante PI multiplicado por el radio al cuadrado).
* */
public class Tarea12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa radio del circulo");
        double radio = scanner.nextDouble();
        double area = 0;
        area = Math.PI * Math.pow(radio,2);
        System.out.println("area = " + area);
    }
}
