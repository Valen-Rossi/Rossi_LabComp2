package S_Gestion_Empleados;

public class EmpleadoAsalariado extends Empleado implements Impuesto{
    @Override
    public double CalcularSueldo() {
        return sueldoBase;
    }

    @Override
    public double calcularImpuesto() {
        return sueldoBase*0.15;
    }
}
