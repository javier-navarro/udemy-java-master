package org.jnavarro.genericsclass;

public class EjemploGenericosClass {
    public static void main(String[] args) {

        Camion <Animal> transporteCaballos = new Camion <>(5);
        transporteCaballos.add(new Animal("Ghost", "velocista"));
        transporteCaballos.add(new Animal("Gladiador", "velocista"));
        transporteCaballos.add(new Animal("Tanque", "fondista"));
        transporteCaballos.add(new Animal("Pier", "fondista"));

        imprimirCamion(transporteCaballos);

        System.out.println('\n');
        Camion <Maquinaria> transporteMaquinarias = new Camion<>(3);
        transporteMaquinarias.add(new Maquinaria("Bulldozer"));
        transporteMaquinarias.add(new Maquinaria("grua horquilla"));
        transporteMaquinarias.add(new Maquinaria("Perforadora"));

        imprimirCamion(transporteMaquinarias);

        System.out.println('\n');
        Camion <Auto> transporteAuto = new Camion<>(3);
        transporteAuto.add(new Auto("Mazda"));
        transporteAuto.add(new Auto("Audi"));
        transporteAuto.add(new Auto("Kia"));

        imprimirCamion(transporteAuto);
    }

    public static <T> void imprimirCamion(Camion<T> camion){
        for (T a: camion){
            if(a instanceof Animal){
                System.out.println(((Animal)a).getNombre() + " tipo: "+((Animal)a).getTipo());
            }
            else if(a instanceof Maquinaria){
                System.out.println(((Maquinaria)a).getTipo());
            }
            else if(a instanceof Auto){
                System.out.println(((Auto)a).getMarca());
            }


        }
    }
}
