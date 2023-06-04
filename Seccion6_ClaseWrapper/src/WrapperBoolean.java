package Seccion6_ClaseWrapper.src;
//clase 71
public class WrapperBoolean {
    public static void main(String[] args) {

        Integer num1 = 1, num2 =2;

        boolean primBoolean = num1 > num2; //falso
        Boolean objBoolean = Boolean.valueOf(primBoolean);
        Boolean objBoolean2 = Boolean.valueOf("false");
        Boolean objBoolean3 = true;

        System.out.println("objBoolean = " + objBoolean);
        System.out.println("objBoolean2 = " + objBoolean2);
        System.out.println("objBoolean3 = " + objBoolean3);

        System.out.println("comparando 2 objetos boolean: "+ (objBoolean == objBoolean2));
        System.out.println("comparando 2 objetos boolean: "+ (objBoolean.equals(objBoolean2)));
        System.out.println("comparando 2 objetos boolean: "+ (objBoolean2 == objBoolean3));
        System.out.println("comparando 2 objetos boolean: "+ (objBoolean == objBoolean3));
        
        boolean primBoolean2 = objBoolean2.booleanValue();
        System.out.println("primBoolean2 = " + primBoolean2);
    }
}
