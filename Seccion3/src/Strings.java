public class Strings {

    public static void main(String[] args) {
        String nombre = "andres";
        String apellido = "soto";
        String tema = "Manejo de \"string\"";

        System.out.println("nombre = " + nombre);
        System.out.println("tema = " + tema);
        System.out.println("nombre completo: "+nombre +" "+apellido);

        String str1 = "Hola Andres";
        String str2 = new String("Hola Andres");

        //chequea si son el mismo objeto
        System.out.println("son el mismo objeto? "+(str1 == str2));

        //chequea si tienen el mismo valor
        System.out.println("Tienen el mismo valor? "+str1.equals(str2));
    }
}
