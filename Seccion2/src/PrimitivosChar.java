package Seccion2.src;

public class PrimitivosChar {
    public static void main(String[] args) {
        char caracter = 'e';
        char caracter2 = '\u0040';
        char decimal = 64;
        char simbolo = '@';
        System.out.println("caracter2 = " + caracter2);
        System.out.println("decimal = " + decimal);
        System.out.println("simbolo = " + simbolo);

        char espacio = '\u0020';
        char retroceso = '\b';
        char tabulador = '\t';
        char nuevaLinea = '\n';
        char retornoCarro = '\r';
        System.out.println("texto de ejemplo =" + espacio + "mas texto");
        System.out.println("texto de ejemplo =" + retroceso + "mas texto");
        System.out.println("texto de ejemplo =" + tabulador + "mas texto");
    }
}
