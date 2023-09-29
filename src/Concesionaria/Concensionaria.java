package Concesionaria;
abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int precio;

    public abstract int calcularImpuesto();

    public abstract String mostrarInfoermacion();

}
public class Moto extends Vehiculo{
    @Override
    public int calcularImpuesto() {
        return precio*2;
    }

    @Override
    public String mostrarInfoermacion() {
        return null;
    }
}