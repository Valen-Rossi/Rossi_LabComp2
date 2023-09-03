package S_Gestion_Empleados;

public class EmpleadoPorHoras extends Empleado implements Impuesto{
    private int horasTrabajadas;

    @Override
    public double CalcularSueldo() {
        return horasTrabajadas*sueldoBase;
    }

    @Override
    public double calcularImpuesto() {
        return sueldoBase*0.15;
    }
}
