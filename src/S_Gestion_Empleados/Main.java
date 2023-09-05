package S_Gestion_Empleados;
import java.util.Scanner;
import java.util.InputMismatchException;
import S_Gestion_Empleados.GestorEmpleados;
public class Main {
    static boolean bool= true;
    public static void main(String[] args) {

        int id;
        Scanner teclado= new Scanner(System.in);
        GestorEmpleados empleados = new GestorEmpleados();
        Empleado empleado= null;
        do {
            System.out.println("Seleccione una opción -->");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Editar empleado");
            System.out.println("3. Mostrar empleados y calcular sueldos e impuestos");
            System.out.println("4. Salir");

            int x= teclado.nextInt();

            switch (x){
                case 1:
                    cargar(teclado, empleados, empleado);
                    break;
                case 2:
                    System.out.println("Ingrese el ID del empleado que desea editar-->");
                    id =  teclado.nextInt();
                    editar(teclado, empleados, id, empleado);
                    break;
                case 3:
                    empleados.mostrar();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while(bool);

    }
    public static void cargar(Scanner teclado, GestorEmpleados empleados, Empleado empleado){
        try{
            System.out.println("Ingrese el nombre del empleado -->");
            String nombre = teclado.next();
            System.out.println("Ingrese el ID del empleado -->");
            int id = teclado.nextInt();
            System.out.println("Ingrese el sueldo base del empleado -->");
            double sueldoBase = teclado.nextDouble();
            System.out.println("Seleccione el tipo de empleado -->");
            System.out.println("1. Empleado por horas");
            System.out.println("2. Empleado de comisión");
            System.out.println("3. Empleado asalariado");
            int y = teclado.nextInt();

            switch (y) {
                case 1:
                    System.out.println("Ingrese las horas trabajadas -->");
                    int horasTrabajadas = teclado.nextInt();
                    empleado = new EmpleadoPorHoras(nombre, id, sueldoBase, horasTrabajadas);
                    empleados.agregarEmpleado(empleado);
                    break;
                case 2:
                    System.out.println("Ingrese las ventas realizadas -->");
                    double ventasRealizadas= teclado.nextDouble();
                    empleado= new EmpleadoComision(nombre,id,sueldoBase,ventasRealizadas);
                    empleados.agregarEmpleado(empleado);
                    break;
                default:
                    empleado= new EmpleadoAsalariado(nombre,id,sueldoBase);
                    empleados.agregarEmpleado(empleado);
                    break;
            }
        } catch (InputMismatchException e){
            System.err.println("Error en la carga de datos");
            bool= false;
        }
    }
    public static void editar(Scanner teclado, GestorEmpleados empleados, int idv, Empleado empleado){
        try{
            System.out.println("Ingrese el nombre del nuevo empleado -->");
            String nombre = teclado.next();
            System.out.println("Ingrese el ID del nuevo empleado -->");
            int id = teclado.nextInt();
            System.out.println("Ingrese el sueldo base del nuevo empleado -->");
            double sueldoBase = teclado.nextDouble();
            System.out.println("Seleccione el tipo de empleado nuevo-->");
            System.out.println("1. Empleado por horas");
            System.out.println("2. Empleado de comisión");
            System.out.println("3. Empleado asalariado");
            int y = teclado.nextInt();
            switch (y) {
                case 1:
                    System.out.println("Ingrese las horas trabajadas -->");
                    int horasTrabajadas = teclado.nextInt();
                    empleado = new EmpleadoPorHoras(nombre, id, sueldoBase, horasTrabajadas);
                    empleados.editarEmpleado(idv,empleado);
                    break;
                case 2:
                    System.out.println("Ingrese las ventas realizadas -->");
                    double ventasRealizadas= teclado.nextDouble();
                    empleado= new EmpleadoComision(nombre,id,sueldoBase,ventasRealizadas);
                    empleados.editarEmpleado(idv,empleado);
                    break;
                default:
                    empleado= new EmpleadoAsalariado(nombre,id,sueldoBase);
                    empleados.editarEmpleado(idv,empleado);
                    break;
            }
        } catch (InputMismatchException e){
            System.err.println("Error en la carga de datos");
            bool= false;
        }
    }
}