package Seccion14_POO_ClasesObjetos;

public enum TipoAutomovil {
    SEDAN("Sedan", "Auto mediano", 4),
    STATION_WAGON("Station Wagon", "Auto grande", 5),
    HATCHBACK("Hatchback", "Auto compacto", 5),
    PICKUP("Pickup", "Camioneta", 4),
    COUPE("Coupé", "Auto pequeño", 2),
    CONVERTIBLE("Convertible", "Auto deportivo", 2),
    FURGON("Furgón", "Auto utilitario", 3);

    private final String nombre;
    private final int numeroPuertas;
    private final String descripcion;

    TipoAutomovil(String nombre,  String descripcion, int numeroPuertas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numeroPuertas = numeroPuertas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
