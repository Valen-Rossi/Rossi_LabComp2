package S_Gestion_Empleados;

public class EmpleadoPorHoras extends Empleado implements Impuesto{
    private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, int id, double sueldoBase, int horasTrabajadas) {
        super(nombre, id, sueldoBase);
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double CalcularSueldo() {
        return horasTrabajadas*sueldoBase;
    }

    @Override
    public double calcularImpuesto() {
        return sueldoBase*0.15;
    }

    @Override
    public String toString() {
        return "Empleado Por Horas [" +
                "horasTrabajadas=" + horasTrabajadas +
                ", nombre='" + nombre + '\'' +
                ", id=" + id +
                ", sueldoBase=" + sueldoBase +
                ", sueldo=" + CalcularSueldo() +
                ", impuesto=" + calcularImpuesto() +
                ']';
    }
}
