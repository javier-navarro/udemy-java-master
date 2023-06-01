public class SentenciaForeach {
    //clase 62
    /*
    Se utiliza para iterar sobre arreglos o colecciones de java
   
    */
    public static void main(String[] args) {
        int numeros[] = { 1,3,5,7,9,11,13,14};
        String[] arregloNombres = { "Andres", "pepe", "maria", "paco", "lalo", "bea", "pato", "pepa" };
        
        for (int num: numeros) {
            System.out.println("num = " + num);
        }
        
        for(String nombre: arregloNombres){
            System.out.println("nombre = " + nombre);
        }
    }
}
