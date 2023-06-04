package Seccion6_ClaseWrapper.src;
//clase 68
public class WrapperInteger {
    public static void main(String[] args) {

        int intPrimitivo = 128;
        Integer intObjeto = Integer.valueOf(intPrimitivo);
        Integer intObjeto2 = intPrimitivo;
        System.out.println("intObjeto = " + intObjeto);
        
        int num = intObjeto;
        System.out.println("num = " + num);

        int num2 = intObjeto.intValue();
        System.out.println("num2 = " + num2);
        
        String valorTv = "67000";
        Integer valor = Integer.valueOf(valorTv);
        System.out.println("valor = " + valor);
        
        Short shortObjeto = intObjeto.shortValue();
        System.out.println("shortObjeto = " + shortObjeto);
        
        Byte byteObjeto = intObjeto.byteValue();
        System.out.println("byteObjeto = " + byteObjeto);
        
    }
}
