public class Empleado extends Persona {

    private double remuneracion;
    private int empleadoId;

    public Empleado(String nombre, String apellido, String numeroFiscal, String direccion, double remuneracion, int empleadoId) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.remuneracion = remuneracion;
        this.empleadoId = empleadoId;
    }

    public Empleado(double remuneracion, int empleadoId) {
        this.remuneracion = remuneracion;
        this.empleadoId = empleadoId;
    }

    public Empleado() {
    }

    public double getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(double aumento) {
        this.remuneracion += aumento;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public void aumentarRemuneracion(int porcentaje){
        double aumento = (this.remuneracion *porcentaje)/100;
        setRemuneracion(aumento);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + getNombre()+ '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", numeroFiscal='" + getNumeroFiscal() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                "remuneracion=" + remuneracion+
                ", empleadoId=" + empleadoId +
                '}';
    }
}
