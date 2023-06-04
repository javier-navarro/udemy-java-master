
//clase75

class Persona{
    private String nombre;
    
    public void modificaNombre(String nuevoNombre){
        this.nombre = nuevoNombre;
    }

    public String leerNombre(){
        return this.nombre;
    }
}

public class PasarPorReferencia2 {
    public static void main(String[] args) {

        Persona persona = new Persona();
        persona.modificaNombre("Andres");

        System.out.println("iniciamos main ");

        System.out.println("persona = " + persona.leerNombre());
        System.out.println("Antes de llamar al metodo test");
        test(persona);
        System.out.println("Despues de llamar al metodo test");

        System.out.println("persona.nombre() = " + persona.leerNombre());
        System.out.println("Finalizamos main con datos modificados");
    }

    public static void test(Persona per){
        System.out.println("Iniciando metodo test ");
        per.modificaNombre("javier");
        System.out.println("Finaliza metodo test ");

    }
}
