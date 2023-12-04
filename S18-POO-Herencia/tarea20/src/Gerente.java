public class Gerente extends Persona{
    private double presupuesto;

    public Gerente(String nombre, String apellido, String numeroFiscal, String direccion, double presupuesto) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.presupuesto = presupuesto;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", numeroFiscal='" + getNumeroFiscal() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", presupuesto=" + presupuesto +
                "} ";
    }
}
