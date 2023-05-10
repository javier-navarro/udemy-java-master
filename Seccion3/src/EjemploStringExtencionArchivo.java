public class EjemploStringExtencionArchivo {
    public static void main(String[] args) {
        String  archivo = "liquidacion.pdf";
        System.out.println("==============================================================================");
        System.out.println("archivo = " + archivo);

        System.out.println("archivo.length() = " + archivo.length());
        System.out.println("archivo.indexOf(\".\") = " + archivo.indexOf("."));
        String extension = archivo.substring(12,15);
        //System.out.println("archivo.substring(11,15) = " + archivo.substring(11,15));
        System.out.println("extension = " + extension);
    }
}
