
import java.util.Date;

public class EjemploOrdenes {
    public static void main(String[] args) {

        OrdenCompra ordenCompra1 = new OrdenCompra("Compras Ofimaticas");
        Cliente cliente1 = new Cliente("Karim","Benzema");

        Producto orden1Producto1 = new Producto("Hp", "mouse", 15000);
        Producto orden1producto2 = new Producto("Asus", "teclado", 17000);
        Producto orden1producto3 = new Producto("Apple", "luces led", 10000);
        Producto orden1producto4 = new Producto("Samsung", "monitor", 200000);

        ordenCompra1.setCliente(cliente1);
        ordenCompra1.setFecha(new Date());
        ordenCompra1.addProducto(orden1Producto1);
        ordenCompra1.addProducto(orden1producto2);
        ordenCompra1.addProducto(orden1producto3);
        ordenCompra1.addProducto(orden1producto4);

        /* Segunda orden */
        OrdenCompra ordenCompra2 = new OrdenCompra("Compras limpieza");
        Cliente cliente2 = new Cliente("Mesut","Ozil");

        Producto orden2Producto1 = new Producto("Clorox", "Cloro", 8000);
        Producto orden2producto2 = new Producto("Ariel", "Detergente", 17000);
        Producto orden2producto3 = new Producto("Confort", "Papel higienico", 15900);
        Producto orden2producto4 = new Producto("Confort", "Servilletas", 2000);

        ordenCompra2.setCliente(cliente2);
        ordenCompra2.setFecha(new Date());
        ordenCompra2.addProducto(orden2Producto1);
        ordenCompra2.addProducto(orden2producto2);
        ordenCompra2.addProducto(orden2producto3);
        ordenCompra2.addProducto(orden2producto4);

        /* tercera orden */
        OrdenCompra ordenCompra3 = new OrdenCompra("Diversion");
        Cliente cliente3 = new Cliente("Cristiano","Ronaldo");

        Producto orden3Producto1 = new Producto("Netflix", "Netflix", 12000);
        Producto orden3producto2 = new Producto("Amazon", "Prime Video", 5000);
        Producto orden3producto3 = new Producto("HBO", "HBO MAX", 7990);
        Producto orden3producto4 = new Producto("Apple", "Apple TV", 4990);

        ordenCompra3.setCliente(cliente3);
        ordenCompra3.setFecha(new Date());
        ordenCompra3.addProducto(orden3Producto1);
        ordenCompra3.addProducto(orden3producto2);
        ordenCompra3.addProducto(orden3producto3);
        ordenCompra3.addProducto(orden3producto4);


        System.out.println("Orden1" + ordenCompra1.toString());
        System.out.println("\nOrden 2 " + ordenCompra2.toString());
        System.out.println("\nOrden 3 " + ordenCompra3.toString());
    }
}