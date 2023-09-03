package S_Gestion_Empleados;
public abstract class Empleado {
    protected String nombre;
    protected int id;
    protected double sueldoBase;

    public abstract double CalcularSueldo();
}
