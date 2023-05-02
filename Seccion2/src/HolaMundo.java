public class HolaMundo {
    public static void main (String[] args){
        String miNombre = "Javier Navarro";
        int edad = 30;
        String profesion = "Ingeniero en informatica";
        boolean valor = false;

        var variable1 = 1;
        System.out.println("Mi nombre es: "+miNombre);
        System.out.println("Mi edad es: "+edad);
        System.out.println("Mi profesion es: "+profesion.toUpperCase());
        if(valor){
            System.out.println("la afirmacion es correcta");
        }else {
            System.out.println("la afirmacion es falsa");
        }

        System.out.println("Mi var: "+variable1);
    }
}