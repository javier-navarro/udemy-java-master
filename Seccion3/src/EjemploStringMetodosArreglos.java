public class EjemploStringMetodosArreglos {
    public static void main(String[] args) {

        String trabalenguas = "trabalenguas";
        String archivo = "alguna.imagen.pdf";
        System.out.println("==============================================================================");
        System.out.println("trabalenguas.toCharArray() = " + trabalenguas.toCharArray());

        char[] arreglo = trabalenguas.toCharArray();

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("arreglo[i] = " + arreglo[i]);
        }

        String[] arreglo2 = trabalenguas.split("a");
        for (int i = 0; i < arreglo2.length; i++) {
            System.out.println("arreglo2[i] = " + arreglo2[i]);
        }

        //para palabras clave se ocuoa  \\ o []
        String[] archivoArreglo = archivo.split("\\.");
        for (int i = 0; i < archivoArreglo.length; i++) {
            System.out.println("archivoArreglo[i] = " + archivoArreglo[i]);
        }

    }

}
