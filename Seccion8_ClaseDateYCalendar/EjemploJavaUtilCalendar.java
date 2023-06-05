package Seccion8_ClaseDateYCalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//clase 78
public class EjemploJavaUtilCalendar {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        /*
        * Calendar es muy customizable, contiene muchas constantes
        * */
        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, Calendar.OCTOBER);
        calendar.set(Calendar.DAY_OF_MONTH, 28);

        //calendar.set(Calendar.HOUR_OF_DAY, 18);
        calendar.set(Calendar.HOUR, 18);
        calendar.set(Calendar.AM_PM, Calendar.PM);
        calendar.set(Calendar.MINUTE, 28);
        calendar.set(Calendar.SECOND, 28);
        calendar.set(Calendar.MILLISECOND, 125);
        //calendar.set(2023,Calendar.APRIL,25,19,20);
        Date fecha = calendar.getTime();
        System.out.println("fecha = " + fecha);

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String fechaStr = df.format(fecha);
        System.out.println("Fecha con formato = " + fechaStr);
    }


}
