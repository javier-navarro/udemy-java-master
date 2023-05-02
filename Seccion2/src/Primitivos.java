package Seccion2.src;

public class Primitivos {
    public static void main(String[] args) {

        byte numeroByte = 7;
        short numeroShort = 32767;
        int numeroInteger = 2147483647;
        Long numeroLong = 9223372036854775807L;
        System.out.println("Byte");
        System.out.println("numeroByte = " + numeroByte);
        System.out.println("Valor minimo : "+ Byte.MIN_VALUE);
        System.out.println("Valor maximo a : "+ Byte.MAX_VALUE);

        System.out.println("short");
        System.out.println("numeroShort = " + numeroShort);
        System.out.println("Valor minimo : "+ Short.MIN_VALUE);
        System.out.println("Valor maximo a : "+ Short.MAX_VALUE);

        System.out.println("int");
        System.out.println("numeroInteger = " + numeroInteger);
        System.out.println("Valor minimo : "+ Integer.MIN_VALUE);
        System.out.println("Valor maximo a : "+ Integer.MAX_VALUE);

        System.out.println("long");
        System.out.println("numeroInteger = " + numeroLong);
        System.out.println("Valor minimo : "+ Long.MIN_VALUE);
        System.out.println("Valor maximo a : "+ Long.MAX_VALUE);

        var numeroVar = 123123213;
        System.out.println("numeroVar = " + numeroVar);
    }
}
