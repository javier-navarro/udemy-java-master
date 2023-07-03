package Seccion14_POO_ClasesObjetos;

public class EjemploAutomovil {
    public static void main(String[] args) {
        Automovil auto = new Automovil();
        auto.setFabricante( "mazda");
        auto.setModelo("mazda 3");
        auto.setCilindrada(2.0);

        Automovil auto2 = new Automovil();
        auto2.setFabricante("kia");
        auto2.setModelo("Sportage");
        auto2.setCilindrada(2.5);
        auto2.setColor(Color.AZUL);

        Automovil nissan = new Automovil("nissan", "navara",Color.VERDE, 3.0, 60);

        System.out.println(auto.toString());
        System.out.println(auto.acelerar(150));
        System.out.println(auto.frenar());
        System.out.println(auto.acelerarFrenar(200));
        System.out.println("Kilometros por litros: " + auto.calculaConsumo(100, 0.50f));

        System.out.println("\n"+ nissan.toString());

    }
}
