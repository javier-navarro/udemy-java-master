package Seccion14_POO_ClasesObjetos;

public class Automovil {
    private int id;
    private String fabricante;
    private String modelo;
    private Color color = Color.GRIS;
    private double cilindrada;
    private int capacidadEstanque = 40;
    private TipoAutomovil tipo;
    private static Color colorPatente = Color.NARANJO;

    private static int capacidadEstanqueEstatico = 30;
    private static int ultimoId;
    public  static final Integer VELOCIDAD_MAXIMA_CARRETERA = 120;
    public  static final Integer VELOCIDAD_MAXIMA_CIUDAD = 60;

    public TipoAutomovil getTipo() {
        return tipo;
    }

    public void setTipo(TipoAutomovil tipo) {
        this.tipo = tipo;
    }

    public Automovil() {
        this.id = ++ultimoId;
    }

    public Automovil(String fabricante, String modelo) {
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public Automovil(String fabricante, String modelo, Color color) {
        this(fabricante, modelo);
        this.color = color;
    }

    public Automovil(String fabricante, String modelo, Color color, double cilindrada, int capacidadEstanque) {
        this(fabricante, modelo,color);
        this.cilindrada = cilindrada;
        this.capacidadEstanque = capacidadEstanque;
    }

    public static Color getColorPatente() {
        return colorPatente;
    }

    public static void setColorPatente(Color colorPatente) {
        Automovil.colorPatente = colorPatente;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getCapacidadEstanque() {
        return capacidadEstanque;
    }

    public void setCapacidadEstanque(int capacidadEstanque) {
        this.capacidadEstanque = capacidadEstanque;
    }

    public static int getCapacidadEstanqueEstatico() {
        return capacidadEstanqueEstatico;
    }

    public static void setCapacidadEstanqueEstatico(int capacidadEstanqueEstatico) {
        Automovil.capacidadEstanqueEstatico = capacidadEstanqueEstatico;
    }

    public void detalle(){
        System.out.println("auto.fabricante = " + this.fabricante);
        System.out.println("auto.modelo = " + this.modelo);
        System.out.println("auto.color = " + this.color);
        System.out.println("auto.cilindrada = " + this.cilindrada);
        System.out.println("\n");
    }

    public String acelerar(int rpm){
        return "el auto "+fabricante +  " acelerando a " + rpm + " rpm";
    }

    public String frenar(){
        return "el auto "+modelo +  " esta frenando!!";
    }

    public String acelerarFrenar(int rpm){
        String acelerar = this.acelerar(rpm);
        String frenar = this.frenar();
        return acelerar + "\n" + frenar;
    }

    public float calculaConsumo(int km, float porcentajeBencina){
        return km/(capacidadEstanque*porcentajeBencina);
    }

    public static float calculaConsumoEstatico(int km, float porcentajeBencina){
        return km/(capacidadEstanqueEstatico*porcentajeBencina);
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "id=" + id +
                ", fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color.getColor() + '\'' +
                ", colorPatente='" + colorPatente.getColor() + '\'' +
                ", cilindrada=" + cilindrada +
                ", capacidadEstanque=" + capacidadEstanque +
                ", tipo=" + tipo.getDescripcion() +
                '}';
    }
}

