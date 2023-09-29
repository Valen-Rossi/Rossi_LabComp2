package Hoteleria;
import java.util.ArrayList;
import java.util.Scanner;
public class Hoteleria {
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        do {
            System.out.println("Menú:\n" +
                    "1. Ver la lista de habitaciones.\n" +
                    "2. Reservar una habitación.\n" +
                    "3. Cancelar una reserva.\n" +
                    "4. Guardar reservas en un archivo.\n" +
                    "5. Cargar reservas desde un archivo.\n" +
                    "6. Salir.\n");
            int x = teclado.nextInt();
            switch (x) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    break;
            }
        }while ();
    }
}
class Hotel{
    private ArrayList<Habitaciones> reserva= new ArrayList<Habitaciones>();
}
class Habitaciones{
    private int numeroHabitacion;
    private int cantidadCamas;
    private int capacidadHuespedes;
    private boolean estado;
    private ArrayList<Huesped> huespedes= new ArrayList<Huesped>();
}
abstract class Persona{
    private String nombre;
    private String apellido;
    private String dni;
}
class Huesped extends Persona implements MostrarInformacion{
    private int idHuesped;

}
interface MostrarInformacion{

}

