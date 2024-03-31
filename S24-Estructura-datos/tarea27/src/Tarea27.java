import org.jnavarro.tarea.model.Vuelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Tarea27 {
    public static void main(String[] args) throws ParseException {

        LinkedList<Vuelo> listadoVuelos = new LinkedList<>();
        listadoVuelos.add(new Vuelo("AAL 933", "New York", "Santiago", formateaFechaNueva(LocalDateTime.parse("2021-08-29T05:39:00")), 62));
        listadoVuelos.add(new Vuelo("LAT 755", "Sao Paulo", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-31T04:45:00")), 47));
        listadoVuelos.add(new Vuelo("SKU 621", "Rio De Janeiro", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-30T16:00:00")), 52));
        listadoVuelos.add(new Vuelo("DAL 147", "New YorkAtlanta", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-29T13:22:00")), 59));
        listadoVuelos.add(new Vuelo("AVA 241", "Bogota", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-31T14:05:00")), 25));
        listadoVuelos.add(new Vuelo("AMX 10", "Mexico City", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-31T05:20:00")), 29));
        listadoVuelos.add(new Vuelo("IBE 6833", "Londres", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-30T08:45:00")), 55));
        listadoVuelos.add(new Vuelo("LAT 2479", "Frankfurt", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-29T07:41:00")), 51));
        listadoVuelos.add(new Vuelo("SKU 803", "Lima", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-30T10:35:00")), 48));
        listadoVuelos.add(new Vuelo("LAT 533", "Los Ángeles", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-29T09:14:00")), 59));
        listadoVuelos.add(new Vuelo("LAT 1447", "Guayaquil", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-31T08:33:00")),31));
        listadoVuelos.add(new Vuelo("CMP 111", "Panama City", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-31T09:57")), 29));
        listadoVuelos.add(new Vuelo("LAT 705", "Madrid", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-30T08:14:00")), 47));
        listadoVuelos.add(new Vuelo("AAL 957", "Miami", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-29T22:53:00")), 60));
        listadoVuelos.add(new Vuelo("ARG 5091", "Buenos Aires", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-31T09:57:00")), 32));
        listadoVuelos.add(new Vuelo("LAT 1283", "Cancún", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-31T15:15:00.000")), 35));
        listadoVuelos.add(new Vuelo("LAT 579", "Barcelona", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-29T07:45:00")),61));
        listadoVuelos.add(new Vuelo("AAL 945", "Dallas-Fort Worth", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-30T07:12:00")), 58));
        listadoVuelos.add(new Vuelo("LAT 501", "Paris", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-29T18:29:00")), 49));
        listadoVuelos.add(new Vuelo("LAT 405", "Montevideo", "Santiago",formateaFechaNueva(LocalDateTime.parse("2021-08-30T15:45:00")), 39));

        Collections.sort(listadoVuelos);

        String nombreUltimoVuelo = listadoVuelos.getLast().nombre;
        String origenUltimoVuelo = listadoVuelos.getLast().origen;
        String fechaUltimoVuelo = listadoVuelos.getLast().fechaLlegada;

        System.out.println("=====================listado vuelos ordenados por fecha ascendente====================================");
        listadoVuelos.forEach(System.out::println);

        System.out.println("El ultimo vuelo en llegar  es: "+ nombreUltimoVuelo +":"+ origenUltimoVuelo+ " ,aterriza el : "+ fechaUltimoVuelo );


        System.out.println('\n');
        listadoVuelos.sort(Comparator.comparing(Vuelo::getCantidadPasajeros).reversed());
        System.out.println("=====================listado vuelos ordenados por cantidad pasajeros ====================================");
        listadoVuelos.forEach(System.out::println);
        String nombreConMenosPasajeros = listadoVuelos.getLast().nombre;
        String origenConMenosPasajeros = listadoVuelos.getLast().origen;
        int cantidadConMenosPasajeros = listadoVuelos.getLast().cantidadPasajeros;

        System.out.println("El vuelo con menor numero de pasajeros es: "+ nombreConMenosPasajeros +":"+ origenConMenosPasajeros+ " ,con "+ cantidadConMenosPasajeros + " pasajeros.");
    }

    //formato para parsear DATE
    public static String formateaFecha( Date fecha){
        String pattern = "EEEEE dd MMMMM yyyy HH:mm";
        SimpleDateFormat formato = new SimpleDateFormat(pattern, new Locale("es"));
        String fechaFormateada = formato.format(fecha);
        return fechaFormateada;
    }

    //para parsear DAte
    public static String formateaFechaNueva (LocalDateTime fecha){
        String pattern = "EEEE, dd 'de' MMMM 'de' yyyy 'a las' HH:mm";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(pattern, new Locale("es"));
        String fechaFormateada = formato.format(fecha);
        return fechaFormateada;
    }
}
