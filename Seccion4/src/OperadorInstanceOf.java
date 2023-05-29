public class OperadorInstanceOf {
    public static void main(String[] args) {
        System.out.println("=================================");

        String texto = "Creando un string";
        Integer numero = 7;
        
        boolean validador = numero instanceof Integer;
        System.out.println("validando numero = " + validador);

        validador= texto  instanceof String;
        System.out.println("validando texto = " + validador);

        //tipos abstractos
        System.out.println("\n");
        Object texto2 = "String nuevo";
        Number num = 7;

        boolean b1 = texto2 instanceof String;
        System.out.println("Texto tipo string = " + b1);

        b1 = texto2 instanceof Integer;
        System.out.println("Texto es del tipo integer = " + b1);

        b1 = texto2 instanceof Boolean;
        System.out.println("Texto es del tipo boolean = " + b1);

        b1 = num instanceof Integer;
        System.out.println("numero es del tipo integer = " + b1);

        b1 = num instanceof Long;
        System.out.println("numero es del tipo Long = " + b1);

        b1 = num instanceof Double;
        System.out.println("Texto es del tipo double = " + b1);

        b1 = num instanceof Short;
        System.out.println("Texto es del tipo double = " + b1);




        
    }
}
