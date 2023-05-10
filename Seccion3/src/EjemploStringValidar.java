public class EjemploStringValidar {
    public static void main(String[] args) {
        String curso = null ;
        String curso2 = " ";
        //curso = "hola";
        boolean esNulo = curso == null;
        System.out.println("========================================================");
        System.out.println("esNulo = " + esNulo);

        /*
        if(!esNulo){
            System.out.println(curso.toString());
        }

         */
        if (esNulo){
            //curso = "Curso de Java Experto.";
            curso = "";
        }
        //validamos si el string esta vacio.
        boolean esVacio = curso.length() == 0;
        boolean esVacio2 = curso.isEmpty();

        //valida si es nulo, vacio y con espacio
        boolean esBlanco = curso2.isBlank();
        System.out.println("esBlanco = " + esBlanco);

        if(!esVacio2){
            System.out.println("Bienqvenido al curso "+curso);
            System.out.println("Bienqvenido al curso ".concat(curso));
        }

        if(!esBlanco){
            System.out.println("dato correcto");
        }else{
            System.out.println("dato incorrecto");
        }



    }
}
