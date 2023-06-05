package Seccion8_ClaseDateYCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Clase 80
public class EjemploJavaUtilDateCompare {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("ingresa fecha con formato 'yyyy-MM-dd'");
        try {
            Date fecha = format.parse(scanner.next());
            System.out.println("fecha = " + fecha);
            System.out.println("format = " + format.format(fecha));

            Date fecha2 = new Date();
            if(fecha.after(fecha2)){
                System.out.println("FEcha user es despues de fecha 2");
            }else if(fecha.before(fecha2)){
                System.out.println("FEcha user es anterior de fecha 2");
            }else if(fecha.equals(fecha2)){
                System.out.println("fechas son iguales.");
            }

            if(fecha.compareTo(fecha2) > 0){
                System.out.println("fecha del usuario esdespues del la fecha2");
            }else if(fecha.compareTo(fecha2) < 0){
                System.out.println("fecha del usuario anterior del la fecha2");
            }else if (fecha.compareTo(fecha2) == 0){
                System.out.println("las fechas son iguales.");
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
