package S_Gestion_Empleados;
import S_Gestion_Empleados.Empleado;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorEmpleados {
    ArrayList<Empleado> empleados;

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public GestorEmpleados() {
        this.empleados = new ArrayList<Empleado>();
    }

    public void agregarEmpleado(Empleado empleado){
       empleados.add(empleado);
    }
    public void editarEmpleado(int id,Empleado empleado){
        int i=0;
        for (Empleado emp: empleados){
            if (id== emp.getId()) {
                empleados.set(i, empleado);
                break;
            }
            else {
                System.out.println("No existe el empleado con ese id");
            }
            i++;
        }
    }
    public void eliminarEmpleado(int id) {
        int i = 0;
        for (Empleado emp : empleados) {
            if (id == emp.getId()) {
                empleados.remove(i);
            } else {
                System.out.println("No existe el empleado con ese id");
            }
            i++;
        }
    }

    public void mostrar() {
        System.out.println("-------------------------------------------------Empleados-------------------------------------------------");
        for (Empleado empleado : empleados) {
            System.out.println(empleado +"\n");
        }
    }

}
