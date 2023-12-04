// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       Persona persona = new Persona("javier","navarro", "STG", "los alerces 123");
       System.out.println("persona.toString() = " + persona.toString());

       Empleado empleado = new Empleado("Cristiano", "ronaldo", "CR7","portugal 123", 1500, 1);
       empleado.aumentarRemuneracion(10);
        System.out.println("empleado.toString() = " + empleado.toString());
        
       Cliente cliente = new Cliente("cliente1","soto", "cl1", "las lilas", 23);
        System.out.println("cliente.toString() = " + cliente.toString());
        
       Gerente gerente = new Gerente("Pablo","marmol", "PM1", "los alerces 123",100000);
       gerente.setPresupuesto(7000);
        System.out.println("gerente.toString() = " + gerente.toString());
    }
}