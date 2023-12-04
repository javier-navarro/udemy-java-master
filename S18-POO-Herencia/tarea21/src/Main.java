
public class Main {
    public static void main(String[] args) {
        
        Producto[] listaProductos = new Producto[8];
        
        Fruta frutillas = new Fruta("Frutillas", 1000, 500,"rosa");
        listaProductos[0] = frutillas;
        
        Fruta sandia = new Fruta("sandia", 5000, 2500,"verde");
        listaProductos[1] = sandia;

        Lacteo leche  = new Lacteo("leche",1500, 3, 500);
        listaProductos[2] = leche;
        
        Lacteo jugo  = new Lacteo("jugo",2000, 5, 200);
        listaProductos[3] = jugo;

        Limpieza cloro = new Limpieza("cloro", 3000, "mucho cloro", 1);
        listaProductos[4] = cloro;
        
        Limpieza raid = new Limpieza("raid", 5000, "XXX", 0.5);
        listaProductos[5] = raid;

        NoPerecible duraznoConserva = new NoPerecible("duraznoConserva", 1000, 1, 800);
        listaProductos[6] = duraznoConserva;
        
        NoPerecible arroz = new NoPerecible("arroz", 1800, 1, 250);
        listaProductos[7] = arroz;

        System.out.println("largo listaProductos = " + listaProductos.length);

        for (int i = 0; i < listaProductos.length ; i++) {
            System.out.println("listaProductos.toString() = " + listaProductos[i]);
        }


    }
}