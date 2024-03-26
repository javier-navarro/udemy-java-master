package org.jnavarro.pooexcepciones.ejemplo;

import javax.imageio.ImageReader;
import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        String valor = JOptionPane.showInputDialog("ingresa entero");
        int divisor;
        double division;

        try {
            divisor = Integer.parseInt(valor);
            division = calculadora.dividir(10, divisor);
            System.out.println(division);

            double division2 = calculadora.dividir("10", "5");
            System.out.println("division2 = " + division2);
        } catch (NumberFormatException  e) {
            System.out.println("se detecto una excepcion: ingrese valor numerico : "+e.getMessage());
            main(args);
        }
        catch (DivisionPorZeroException  e) {
            System.out.println("capturamos la excepcion en tiempo de ejecucion: "+e.getMessage());
            main(args);
        } catch (FormatoNumeroException e) {
            System.out.println("Se detecto una excepcion , ingresa numero valido: "+e.getMessage());
            e.printStackTrace(System.out);
        } finally {
            System.out.println("opcional que se ejecuta siempre");
        }

    }
}