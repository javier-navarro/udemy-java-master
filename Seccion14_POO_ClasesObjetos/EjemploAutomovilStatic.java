package Seccion14_POO_ClasesObjetos;

public class EjemploAutomovilStatic {
    public static void main(String[] args) {


        Automovil auto = new Automovil();
        auto.setFabricante( "mazda");
        auto.setModelo("mazda 3");
        auto.setCilindrada(2.0);
        auto.setTipo(TipoAutomovil.HATCHBACK);

        Automovil auto2 = new Automovil();
        auto2.setFabricante("kia");
        auto2.setModelo("Sportage");
        auto2.setCilindrada(2.5);
        auto2.setColor(Color.ROJO);
        auto2.setTipo(TipoAutomovil.STATION_WAGON);

        Automovil nissan = new Automovil("nissan", "navara",Color.BLANCO, 3.0, 60);
        nissan.setTipo(TipoAutomovil.PICKUP);
        Automovil.setColorPatente(Color.AZUL);


        System.out.println("\n"+ nissan.toString());
        System.out.println("\n"+ auto.toString());
        System.out.println("\n"+ auto2.toString());

        System.out.println("Automovil.getColorPatente() = " + Automovil.getColorPatente());
        System.out.println("kilometros por litros " + Automovil.calculaConsumoEstatico(300,60));

    }
}
