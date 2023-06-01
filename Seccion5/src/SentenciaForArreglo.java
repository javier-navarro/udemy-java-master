import java.util.Scanner;

public class SentenciaForArreglo {
    //clase 60.
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] arregloNombres = { "Andres", "pepe", "maria", "paco", "lalo", "bea", "pato", "pepa" };

        for (int i = 0; i < arregloNombres.length; i++) {
            if(arregloNombres[i].equalsIgnoreCase("andres") || arregloNombres[i].equalsIgnoreCase("pepa") ){
                continue;
            }
            System.out.println(i + " -" + arregloNombres[i]);
        }
        System.out.println("Ingresa nombre a buscar: ");
        String buscar = scanner.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < arregloNombres.length; i++) {
            if(arregloNombres[i].equalsIgnoreCase(buscar)){
                encontrado = true;
                break;
            }
        }
        if(encontrado){
            System.out.println( buscar + " fue encontrado");
        }else {
            System.out.println( buscar + " no fue encontrado");
        }

    }
}
