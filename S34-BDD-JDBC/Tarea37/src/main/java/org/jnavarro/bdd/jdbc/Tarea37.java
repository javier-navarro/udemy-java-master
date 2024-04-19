package org.jnavarro.bdd.jdbc;

import org.jnavarro.bdd.jdbc.modelo.Usuario;
import org.jnavarro.bdd.jdbc.repositorio.UsuarioRepositorio;
import org.jnavarro.bdd.jdbc.repositorio.UsuarioRepositorioImpl;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Tarea37 {
    public static void main(String[] args) {

        UsuarioRepositorio<Usuario> repositorio = new UsuarioRepositorioImpl();
        String respuestaUsuario = lanzaMenu();

        if (respuestaUsuario == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una operación");
        } else {
            switch (respuestaUsuario){
                case "1":
                    Usuario user = new Usuario();
                    int actualizacion = JOptionPane.showConfirmDialog(null, "Deseas Actualizar?");
                    System.out.println( "param :"+actualizacion);
                    if (actualizacion == 0) {
                        Long id = Long.parseLong(JOptionPane.showInputDialog(null, "ingresa id", "Editando usuario",
                                JOptionPane.INFORMATION_MESSAGE));
                        user.setId(id);
                        String username = JOptionPane.showInputDialog(null, "ingresa username", "Editando usuario",
                                JOptionPane.INFORMATION_MESSAGE);
                        user.setUsername(username);
                        String password = JOptionPane.showInputDialog(null, "ingresa password", "Editando usuario",
                                JOptionPane.INFORMATION_MESSAGE);
                        user.setPassword(password);
                        String email = JOptionPane.showInputDialog(null, "ingresa email", "Editando usuario",
                                JOptionPane.INFORMATION_MESSAGE);
                        user.setEmail(email);
                        repositorio.guardarUsuario(user);
                        JOptionPane.showMessageDialog(null, "MODIFICACION EXITOSA");

                    } else if (actualizacion == 1) {
                        System.out.println("===================AGREGANDO / UPDATE ===============================");

                        String username = JOptionPane.showInputDialog(null,"ingresa username", "Agregando usuario",
                                JOptionPane.INFORMATION_MESSAGE);
                        user.setUsername(username);
                        String password = JOptionPane.showInputDialog(null,"ingresa password", "Agregando usuario",
                                JOptionPane.INFORMATION_MESSAGE);
                        user.setPassword(password);
                        String email = JOptionPane.showInputDialog(null,"ingresa email", "Agregando usuario",
                                JOptionPane.INFORMATION_MESSAGE);
                        user.setEmail(email);
                        repositorio.guardarUsuario(user);
                        JOptionPane.showMessageDialog(null, "CREACION EXITOSA");

                        repositorio.listarUsuarios();
                    }
                    main(args);

                    break;
                case "2":
                    System.out.println("===================ELIMINANDO===============================");
                    Long id = Long.parseLong(JOptionPane.showInputDialog(null,"ingresa id", "Eliminar Usuario",
                            JOptionPane.INFORMATION_MESSAGE));
                    repositorio.eliminarUsuario(id);
                    JOptionPane.showMessageDialog(null, "ELIMINACION EXITOSA");
                    repositorio.listarUsuarios().forEach(System.out::println);
                    main(args);
                    break;

                case "3":
                    System.out.println("===================buscando usuario===============================");
                    id = Long.parseLong(JOptionPane.showInputDialog(null, "ingresa id", "BUSCAR USUARIO ",
                            JOptionPane.INFORMATION_MESSAGE));
                    System.out.println("buscando = "+ repositorio.buscaUsuarioPorId(id));
                    main(args);
                    break;

                case "4":
                    System.out.println("===================listar===============================");
                    repositorio.listarUsuarios().forEach(System.out::println);
                    main(args);
                    break;
                case "5":
                    System.out.println("Saliendo del sistema......");
                    System.exit(5);
                default:
                    System.exit(1);
            }
        }
    }

    private static String lanzaMenu(){
        Map<String, String> operaciones = new HashMap();
        operaciones.put("Agregar / Actualizar","1");
        operaciones.put("Eliminar", "2");
        operaciones.put("buscar", "3");
        operaciones.put("Listar", "4");
        operaciones.put("Salir", "5");

        Object[] opArreglo = operaciones.keySet().toArray();

        Object opcion = JOptionPane.showInputDialog(null,
                "Seleccione un Operación",
                "Mantenedor de Usuarios",
                JOptionPane.INFORMATION_MESSAGE, null, opArreglo, opArreglo[0]);

        return operaciones.get(opcion.toString());
    }
}
