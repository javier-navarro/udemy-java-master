import java.util.Arrays;
import java.util.Date;

public class OrdenCompra {
    private Integer identificador;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private Producto[] productos;

    private static int ultimoId;
    private  int indice = 0;


    public OrdenCompra(){

    }
    public OrdenCompra(String descripcion) {
        this.descripcion = descripcion;
        this.identificador = ++ultimoId;
        this.productos = new Producto[4];
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void addProducto(Producto producto){
        this.productos[indice++] = producto;
    }

    public int granTotal(){
        int resultado = 0;
        for(Producto p: this.getProductos()){
            resultado += p.getPrecio();
        }
        return resultado;
    }
    public String listaProductos(){
        String salida = "";
        for(Producto p: this.getProductos()){
            salida += "\n\t"+"Fabricante: "+ p.getFabricante() +", nombre: "+p.getNombre() + ", precio: $"+p.getPrecio();
        }
        return salida;
    }

    @Override
    public String toString() {
        return
                "\nidentificador: " + identificador +
                "\ndescripcion: " + descripcion +
                "\nfecha: " + fecha +
                "\ncliente: " + cliente.getNombre() + " "+cliente.getApellido() +
                "\nproductos:" + listaProductos()+
                "\ntotalCompras: " + granTotal() +"";
    }
}
