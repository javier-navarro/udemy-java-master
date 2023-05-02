package Seccion2.src;

public class PrimitivoBoolean {
    public static void main(String[] args) {

        boolean respuestaVerdadera = true;
        boolean respuestaFalsa = false;

        int numero1 = 1500;
        int numero2 = 3500;

        System.out.println("respuestaVerdadera = " + respuestaVerdadera);
        System.out.println("respuestaFalsa = " + respuestaFalsa);

        if( numero1 > numero2){
            System.out.println(respuestaFalsa);
        }else {
            System.out.println(respuestaVerdadera);
        }


    }
}
