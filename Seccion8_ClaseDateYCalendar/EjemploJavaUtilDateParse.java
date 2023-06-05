package Seccion8_ClaseDateYCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Clase 79
public class EjemploJavaUtilDateParse {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("ingresa fecha con formato 'yyyy-MM-dd'");
        try {
            Date fecha = format.parse(scanner.next());
            System.out.println("fecha = " + fecha);
            System.out.println("format = " + format.format(fecha));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
