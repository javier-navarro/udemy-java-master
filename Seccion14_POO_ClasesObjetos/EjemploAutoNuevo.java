package Seccion14_POO_ClasesObjetos;

public class EjemploAutoNuevo {
    public static void main(String[] args) {

        Motor motorMercedez = new Motor(2.0, TipoMotor.BENCINA);
        Motor motorBmw = new Motor(3.0, TipoMotor.BENCINA);
        Motor motorMazda = new Motor(2.5, TipoMotor.DISEL);

        Persona conductorMercedez = new Persona("Cristiano", "Ronaldo");
        Persona conductorBmw = new Persona("Mesut", "Ozil");
        Persona conductorMazda = new Persona("Edin", "Dzeko");

        Rueda[] ruedasMercedez = new Rueda[5];
        for (int i = 0; i < ruedasMercedez.length; i++) {
            ruedasMercedez[i] = new Rueda("yokohama", 16, 7.5);
        }


        Rueda[] ruedasBmw = new Rueda[5];
        for (int i = 0; i < ruedasBmw.length; i++) {
            ruedasBmw[i] = new Rueda("Michellin", 18, 9);
        }

        AutoNuevo mercedez = new AutoNuevo("Mercedez", "A200");
        mercedez.setMotor(motorMercedez);
        mercedez.setEstanque(new Estanque());
        mercedez.setColor(Color.ROJO);
        mercedez.setTipo(TipoAutomovil.HATCHBACK);
        mercedez.setConductor(conductorMercedez);
        mercedez.setRuedas(ruedasMercedez);

        AutoNuevo bmw = new AutoNuevo("Bmw", "X5 M", Color.GRIS, motorBmw,new Estanque(50),conductorBmw,ruedasBmw);
        bmw.setTipo(TipoAutomovil.COUPE);

        AutoNuevo mazda = new AutoNuevo("Mazda", "BT-50",Color.NARANJO,motorMazda,new Estanque(60));
        mazda.setTipo(TipoAutomovil.PICKUP);
        mazda.setConductor(conductorMazda);

        /*
        Rueda[] ruedasMazda = new Rueda[5];
        for (int i = 0; i < ruedasMazda.length; i++) {
            //ruedasMazda[i] = new Rueda("Goodyear", 19, 11);
            mazda.addRueda(new Rueda("Goodyear", 19, 11));
        }

         */
        Rueda[] ruedasMazda = new Rueda[5];
        for (int i = 0; i < ruedasMazda.length; i++) {
            mazda.addRueda(new Rueda("Goodyear", 19, 11));
        }
        //mazda.setRuedas(ruedasMazda);

        System.out.println("\n"+ mercedez.toString());
        System.out.println("\n"+ bmw.toString());
        System.out.println("\n"+ mazda.toString());

    }
}
