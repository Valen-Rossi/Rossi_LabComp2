package S_Gestion_Empleados;

public class EmpleadoComision extends Empleado implements Impuesto{
    private double ventasRealizadas;

    public EmpleadoComision(String nombre, int id, double sueldoBase, double ventasRealizadas) {
        super(nombre, id, sueldoBase);
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    public double CalcularSueldo() {
        return ventasRealizadas+sueldoBase;
    }

    @Override
    public double calcularImpuesto() {
        return sueldoBase*0.1;
    }

    @Override
    public String toString() {
        return "Empleado Comision [" +
                "ventasRealizadas=" + ventasRealizadas +
                ", nombre='" + nombre + '\'' +
                ", id=" + id +
                ", sueldoBase=" + sueldoBase +
                ", sueldo=" + CalcularSueldo() +
                ", impuesto=" + calcularImpuesto() +
                ']';
    }
}
