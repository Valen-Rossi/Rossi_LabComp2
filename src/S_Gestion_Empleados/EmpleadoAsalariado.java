package S_Gestion_Empleados;

public class EmpleadoAsalariado extends Empleado implements Impuesto{
    public EmpleadoAsalariado(String nombre, int id, double sueldoBase) {
        super(nombre, id, sueldoBase);
    }

    @Override
    public double CalcularSueldo() {
        return sueldoBase;
    }

    @Override
    public double calcularImpuesto() {
        return sueldoBase*0.05;
    }

    @Override
    public String toString() {
        return "Empleado Asalariado [" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", sueldoBase=" + sueldoBase +
                ", sueldo=" + CalcularSueldo() +
                ", impuesto=" + calcularImpuesto() +
                ']';
    }
}
