public class EjemploStringConcatenacion {
    public static void main(String[] args) {

        String curso = "Programacion Java";
        String profesor = "Cristiano Ronaldo";

        String detalle = curso + " con el instructor: " + profesor;
        System.out.println("detalle = " + detalle);

        int numeroA = 10;
        int numeroB = 5;

        System.out.println(detalle+numeroA+numeroB);
        //concatenando con metodo.
        
        String detalle2 = curso.concat( " con el instructor: ".concat(profesor));
        System.out.println("detalle2 = " + detalle2);


        //inmutabilidad
        System.out.println("========================================================");
        String resultado = curso.concat(profesor);
        System.out.println("resultado = " + resultado);
        System.out.println(curso == resultado);

        String resultado2 = curso.transform( c -> {
            return c +" con" + profesor;
        });
        System.out.println("resultado2  = " + resultado2);

        resultado2.replace("a", "A");
        System.out.println("resultado2 con replace = " + resultado2);
        //para que tome el cambio debe asignarse a una variable nueva
        String resultado3 = resultado2.replace("a", "A");
        System.out.println("resultado3 = " + resultado3);
    }
}
