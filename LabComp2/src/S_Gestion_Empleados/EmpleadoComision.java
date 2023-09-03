package S_Gestion_Empleados;

public class EmpleadoComision extends Empleado implements Impuesto{
    private double ventasRealizadas;

    @Override
    public double CalcularSueldo() {
        return ventasRealizadas+sueldoBase;
    }

    @Override
    public double calcularImpuesto() {
        return sueldoBase*0.15;
    }
}
