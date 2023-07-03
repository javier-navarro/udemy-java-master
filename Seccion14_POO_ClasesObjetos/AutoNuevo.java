package Seccion14_POO_ClasesObjetos;

public class AutoNuevo {
    private int id;
    private String fabricante;
    private String modelo;
    private Color color = Color.GRIS;
    private Motor motor;
    private Estanque estanque;
    private Persona conductor;

    private Rueda[] ruedas;
    private int indiceRueda = 0;
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

    public AutoNuevo(String fabricante, String modelo) {
        this.id = ++ultimoId;
        this.ruedas = new Rueda[5];
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public AutoNuevo(String fabricante, String modelo, Color color) {
        this(fabricante, modelo);
        this.color = color;
    }

    public AutoNuevo(String fabricante, String modelo, Color color, Motor motor, Estanque estanque) {
        this(fabricante, modelo,color);
        this.motor = motor;
        this.estanque = estanque;
    }

    public AutoNuevo(String fabricante, String modelo, Color color, Motor motor, Estanque estanque, Persona conductor, Rueda[] ruedas) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.color = color;
        this.motor = motor;
        this.estanque = estanque;
        this.conductor = conductor;
        this.ruedas = ruedas;
    }

    public static Color getColorPatente() {
        return colorPatente;
    }

    public static void setColorPatente(Color colorPatente) {
        AutoNuevo.colorPatente = colorPatente;
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

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Estanque getEstanque() {
        return estanque;
    }

    public void setEstanque(Estanque estanque) {
        this.estanque = estanque;
    }

    public Persona getConductor() {
        return conductor;
    }

    public void setConductor(Persona conductor) {
        this.conductor = conductor;
    }

    public Rueda[] getRuedas() {
        return ruedas;
    }

    public void setRuedas(Rueda[] ruedas) {
        this.ruedas = ruedas;
    }

    public void addRueda(Rueda rueda){
        this.ruedas[indiceRueda++] = rueda;
    }

    public static int getCapacidadEstanqueEstatico() {
        return capacidadEstanqueEstatico;
    }

    public static void setCapacidadEstanqueEstatico(int capacidadEstanqueEstatico) {
        AutoNuevo.capacidadEstanqueEstatico = capacidadEstanqueEstatico;
    }

    public void detalle(){
        System.out.println("auto.fabricante = " + this.fabricante);
        System.out.println("auto.modelo = " + this.modelo);
        System.out.println("auto.color = " + this.color);
        System.out.println("auto.motor = " + this.motor.getCilindrada());
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
        return km/(estanque.getCapacidad()*porcentajeBencina);
    }

    public static float calculaConsumoEstatico(int km, float porcentajeBencina){
        return km/(capacidadEstanqueEstatico*porcentajeBencina);
    }

    /*
    @Override
    public String toString() {
        return "Automovil{" +
                "id=" + id +
                ", fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color.getColor() + '\'' +
                ", colorPatente='" + colorPatente.getColor() + '\'' +
                ", cilindrada=" + motor.getCilindrada() +
                ", capacidadEstanque=" + estanque.getCapacidad() +
                ", tipo=" + tipo.getDescripcion() +
                '}';
    }

     */

    @Override
    public String toString() {
        return "AutoNuevo{" +
                "id=" + id +
                ", fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color=" + color +
                ", motor=" + motor.getTipo() +
                ", estanque=" + estanque.getCapacidad() +
                ", conductor=" + conductor +
                ", ruedas=" + muestraRuedas()+
                ", tipo=" + tipo +
                '}';
    }

    public String muestraRuedas(){
        String salida = "";
        for(Rueda r : this.getRuedas()){
            salida += "\n" +r.getFabricante() + ", aro: "+ r.getAro();
        }
        return salida;
    }
}
