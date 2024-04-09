package org.jnavarro.api.stream.ejemplos;

import org.jnavarro.api.stream.ejemplos.model.Factura;
import org.jnavarro.api.stream.ejemplos.model.Usuario;

import java.util.Arrays;
import java.util.List;

public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {

        Usuario usuario1 = new Usuario("Mikasa", "Ackerman");
        Usuario usuario2 = new Usuario("Eren", "Jaeger");

        usuario1.addFacturas(new Factura("compras tecnologia"));
        usuario1.addFacturas(new Factura("compras oficina"));

        usuario2.addFacturas(new Factura("compras cocina"));
        usuario2.addFacturas(new Factura("compras diversion"));

        List<Usuario> usuarios = Arrays.asList(usuario1,usuario2);
        usuarios.stream()
                .flatMap( u-> u.getFacturas().stream())
                .forEach(f-> System.out.println(f.getDescripcion()
                                .concat(" :")
                                .concat(f.getUsuario().toString())
                        ));

        System.out.println("============== son lo mismo =========================");
        for (Usuario u: usuarios){
            for (Factura f: u.getFacturas()){
                System.out.println(f.getDescripcion());
            }
        }
    }
}
