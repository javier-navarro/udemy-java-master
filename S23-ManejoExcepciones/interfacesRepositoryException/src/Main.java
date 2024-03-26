import org.jnavarro.poointerfaces.modelo.Cliente;
import org.jnavarro.poointerfaces.repositorio.*;
import org.jnavarro.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.jnavarro.poointerfaces.repositorio.excepciones.EscrituraAccesoDatos;
import org.jnavarro.poointerfaces.repositorio.excepciones.LecturaDatoException;
import org.jnavarro.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {


            OrdenablePaginableCrudRepositorio<Cliente> repositorio = new ClienteListRepositorio();
            repositorio.crearCliente(new Cliente("Cristiano", "Ronaldo"));
            repositorio.crearCliente(new Cliente("Erling", "Haaland"));
            repositorio.crearCliente(new Cliente("Kylian", "Mbappe"));
            repositorio.crearCliente(new Cliente("Kevin ", "De Bruyne"));

            repositorio.crearCliente(null);

            List<Cliente> clientes = repositorio.listar();
            clientes.forEach(cliente -> System.out.println(cliente));
            System.out.println("\n");

            System.out.println("===== paginable ======");
            List<Cliente> paginable = ((PaginableRepositorio) repositorio).listar(1, 3);
            paginable.forEach(cliente -> System.out.println(cliente));
            System.out.println("\n");

            System.out.println("===== Ordenar x nombre ASC ======");
            List<Cliente> clientesOrdenadosAsc = ((OrdenableRepositorio) repositorio).listar("nombre", Direccion.ASC);
            for (Cliente cli : clientesOrdenadosAsc) {
                System.out.println(cli);
            }
            System.out.println("\n");

            System.out.println("===== Ordenar x nombre DESC ======");
            List<Cliente> clientesOrdenadosDesc = ((OrdenableRepositorio) repositorio).listar("nombre", Direccion.DESC);
            for (Cliente cli : clientesOrdenadosDesc) {
                System.out.println(cli);
            }
            System.out.println("\n");

            System.out.println("===== Ordenar x apellido ASC ======");
            List<Cliente> clientesOrdenadosApellidoAsc = ((OrdenableRepositorio) repositorio).listar("apellido", Direccion.ASC);
            for (Cliente cli : clientesOrdenadosApellidoAsc) {
                System.out.println(cli);
            }
            System.out.println("\n");

            System.out.println("===== Ordenar x apellido DESC ======");
            List<Cliente> clientesOrdenadosApellidoDesc = ((OrdenableRepositorio) repositorio).listar("apellido", Direccion.DESC);
            for (Cliente cli : clientesOrdenadosApellidoDesc) {
                System.out.println(cli);
            }
            System.out.println("\n");

            System.out.println("===== Editar ======");
            Cliente clienteActualizado = new Cliente("Zlatan", "Ibrahimovic");
            clienteActualizado.setId(3);
            repositorio.editarCliente(clienteActualizado);
            Cliente zlatan = (Cliente) repositorio.porId(3);
            System.out.println(zlatan);
            System.out.println("\n");

            System.out.println("===== eliminar ======");
            repositorio.eliminarCliente(3);
            repositorio.listar().forEach(System.out::println);

            System.out.println("\n");

            System.out.println("===== total ======");
            repositorio.total();

        }catch (LecturaDatoException e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }catch (EscrituraAccesoDatos e){
            System.out.println("Escritura " +e.getMessage());
            e.printStackTrace();
        }
        catch (AccesoDatoException a){
            System.out.println(a.getMessage());
            a.printStackTrace();
        }
    }
}