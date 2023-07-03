package Seccion14_POO_ClasesObjetos;

public class EjemploAutomovilEnum {
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

        System.out.println("\nAutomovil.getColorPatente() = " + Automovil.getColorPatente());
        System.out.println("kilometros por litros " + Automovil.calculaConsumoEstatico(300,60));

        TipoAutomovil tipoMazda = auto.getTipo();
        System.out.println("\nnombre :" +tipoMazda.getNombre());
        System.out.println("descripcion: " +tipoMazda.getDescripcion());
        //System.out.println("\n");


        switch (tipoMazda){
            case CONVERTIBLE:
                System.out.println("El auto es deportivo de dos puertas");
                break;
            case COUPE:
                System.out.println("El auto es pequeño");
                break;
            case FURGON:
                System.out.println("El auto es utilitario de transporte");
                break;
            case HATCHBACK:
                System.out.println("El auto es mediano compacto");
                break;
            case PICKUP:
                System.out.println("El auto esuna camioneta");
                break;
            case SEDAN:
                System.out.println("El auto es mediano");
                break;
            case STATION_WAGON:
                System.out.println("El auto es gigante");
                break;
        }

        TipoAutomovil[] tipos = TipoAutomovil.values();
        for (TipoAutomovil ta: tipos) {
            System.out.println(ta + " => " + ta.name() + ", " +
                    ta.getNombre()+ ", "+
                    ta.getDescripcion()+ ", "+
                    ta.getNumeroPuertas()
            );
            System.out.println();
        }



    }
}
