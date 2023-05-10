public class EjemploString {
    public static void main(String[] args) {
        
        String curso = "Programacion Java";
        String curso2 = new String("Programacion java") ;
        
        boolean esIgual = curso.equals(curso2);
        boolean esIgual3 = curso.equalsIgnoreCase(curso2);
        boolean esIgual2 = curso == curso2;

        System.out.println("curso.equals = " + esIgual);
        System.out.println("curso == curso2 = " + esIgual2);
        System.out.println("curso.equalsIgnoreCase = " + esIgual3);


    }
}
