package Seccion13_Matrices;
// Clase 118 - Ejemplo de matriz string con for
public class EjemploMatricesString {
    public static void main(String[] args) {
        String[][] nombres = new String[3][2];

        nombres[0][0] = "pepe";
        nombres[0][1] = "pepa";
        nombres[1][0] = "josefa";
        nombres[1][1] = "paco";
        nombres[2][0] = "lucas";
        nombres[2][1] = "pancha";

        System.out.println(" Iterando con for: ");

        for (int i = 0; i < nombres.length; i++) {
            for (int j = 0; j < nombres[i].length; j++) {
                System.out.print(nombres[i][j]+ "\t");
            }
            System.out.println();
        }
        System.out.println("\n ============================");
        System.out.println(" Iterando con foreach: ");

        for (String[] fila: nombres) {
            for (String nombre: fila) {
                System.out.print(nombre + "\t");
            }
            System.out.println();
        }
    }
}
