package Seccion2.src;

public class ConversionDeTipos {
    public static void main(String[] args) {
        String numeroString = "50";
        int numeroInt = Integer.parseInt(numeroString);
        System.out.println("numeroInt = " + numeroInt);
        
        String realStr = "283.7648273";
        double realDouble = Double.parseDouble(realStr);
        System.out.println("realDouble = " + realDouble);

        //string a boolean
        String logicoStr = "1";
        boolean logicoBoolean = Boolean.parseBoolean(logicoStr);
        System.out.println("logicoBoolean = " + logicoBoolean);
        
        //primitivos a cadenas
        int otronumeroInt = 100;
        System.out.println("otronumeroInt = " + otronumeroInt);
        
        String otroNumeroStr = Integer.toString(otronumeroInt);
        System.out.println("otroNumeroStr = " + otroNumeroStr);

        otroNumeroStr = String.valueOf(otronumeroInt+10);
        System.out.println("otroNumeroStr = " + otroNumeroStr);


        //double a cadena
        double otroRealDouble = 3.14;
        String otroRealStr = Double.toString(otroRealDouble);
        System.out.println("otroRealStr = " + otroRealStr);
        
        otroRealStr = String.valueOf(1.1919);
        System.out.println("otroRealStr = " + otroRealStr);

        //conversion entre primitivos
        //solo entre tipos de datos del mismo tipo.
        int i = 10000;
        short s = (short)i;
        System.out.println("s = " + s);
        long l = i;
        System.out.println("l = " + l);
        System.out.println("max_value = "+ Short.MAX_VALUE);
    }
}
