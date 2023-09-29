package Examen1;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class HospitalPerrando implements Serializable{
    Scanner teclado= new Scanner(System.in);
    String datos;
     try (Scanner entrada = new Scanner(new File("datos.txt"))) {
        datos = entrada.nextLine();
    } catch (FileNotFoundException e) {
        System.err.println("Error al leer los datos del hospital desde el archivo: " + e.getMessage());
    }
     Hospital hospital= new Hospital(datos);
    int opcion;
    String nombrePaciente;
    int dniPaciente;
    Date fechaDeNacimientoPaciente;
    int numeroDeTelefono;
    int tipoDeSangre;
    String historial;
    List<String> historialMedico;
    List<Paciente> pacientes;
    do {

        System.out.println("Hospital Julio C. Perrando - Av. 9 de Julio 1100 · 0362 444-2399\n" +
                "Menú:\n" +
                "1. Listar Doctores.\n" +
                "2. Registrar un nuevo paciente.\n" +
                "3. Actualizar información personal de un paciente.\n" +
                "4. Consultar el historial médico de un paciente.\n" +
                "5. Nuevo historial para un paciente. \n" +
                "6. Guardar Historial de pacientes en archivo \n" +
                "7. Cargar Historial de pacientes desde archivo \n" +
                "8. Salir.\n");
        opcion = teclado.nextInt();
        switch (opcion) {
            case 1:
                hospital.verListaDoctores();
                break;
            case 2:
                System.out.println("Ingrese el nombre del paciente: ");
                nombrePaciente = teclado.next();
                System.out.println("Ingrese el DNI del paciente: ");
                dniPaciente = teclado.nextInt();
                System.out.println("Ingrese la fecha de nacimiento del paciente: ");
                fechaDeNacimientoPaciente = new SimpleDateFormat("dd/MM/yyyy").parse(teclado.nextLine());
                System.out.println("Ingrese el número de telefono del paciente: ");
                numeroDeTelefono= teclado.nextInt();
                System.out.println("Ingrese el tipo de sangre del paciente: ");
                tipoDeSangre= teclado.nextInt();
                System.out.println("Ingrese el historial medico del paciente: ");
                historial= teclado.next();
                historialMedico.add(historial);
                pacientes = new ArrayList<>();
                pacientes.add(new Paciente(nombrePaciente, dniPaciente, fechaDeNacimientoPaciente, numeroDeTelefono, tipoDeSangre, historialMedico));
                break;
            case 3:
                System.out.println("Ingrese el DNI del paciente que desea actualizar");
                dniPaciente =  teclado.nextInt();
                System.out.println("Ingrese el nombre del paciente: ");
                nombrePaciente = teclado.next();
                System.out.println("Ingrese la fecha de nacimiento del paciente: ");
                fechaDeNacimientoPaciente = new SimpleDateFormat("dd/MM/yyyy").parse(teclado.nextLine());
                System.out.println("Ingrese el número de telefono del paciente: ");
                numeroDeTelefono= teclado.nextInt();
                System.out.println("Ingrese el tipo de sangre del paciente: ");
                tipoDeSangre= teclado.nextInt();
                System.out.println("Ingrese el historial medico del paciente: ");
                historial= teclado.next();
                historialMedico.add(historial);
                pacientes = new ArrayList<>();
                for (Paciente paciente: pacientes) {
                    if (paciente.getDni()==dniPaciente){
                        pacientes.set(Paciente(nombrePaciente, dniPaciente, fechaDeNacimientoPaciente, numeroDeTelefono, tipoDeSangre, historialMedico));
                    }
                    else {
                        System.out.println("Paciente no encontrado");
                    }
                }
                break;
            case 4:
                System.out.println("Ingrese el DNI del paciente que desea ver su historial médico");
                dniPaciente =  teclado.nextInt();

                for (Paciente paciente: pacientes) {
                    if (paciente.getDni()==dniPaciente){
                        paciente.verHistorialDeEventos();
                    }
                    else {
                        System.out.println("Paciente no encontrado");
                    }
                }
                break;
            case 5:
                System.out.println("Ingrese el DNI del paciente que desea actualizar su historial médico");
                dniPaciente =  teclado.nextInt();
                System.out.println("Ingrese el historial medico del paciente: ");
                historial= teclado.next();
                for (Paciente paciente: pacientes) {
                    if (paciente.getDni()==dniPaciente){
                        pacientes.set(Paciente(historial));
                    }
                    else {
                        System.out.println("Paciente no encontrado");
                    }
                }
                break;
            case 6:
                hospital.guardarHistorialEnArchivo("historial.dat");
                break;
            case 7:
                hospital = hospital.cargarHistorialDesdeArchivo("historial.dat");
                if (hospital != null) {
                    System.out.println("Historial cargado desde archivo exitosamente.");
                } else {
                    System.out.println("Error al cargar el historial desde el archivo.");
                }
                break;
            case 8:
                System.out.println("Muchas Gracias");
                break;
            default:
                System.out.println("Opción no válida. Por favor, elija una opción válida.");
        }
    } while (opcion != 8);
}
class Hospital implements Serializable{
    private String datos;

    private List<Doctor> doctores;
    public Hospital(String datos) {
        this.datos = datos;
    }

    public void verListaDoctores() {
        System.out.println("Datos del Hospital: " + nombreHotel + "\n");
        System.out.println("Lista de Doctores: \n");

        for (Doctor doctor : doctores) {
            doctor.mostrarInformacion();
            System.out.println();
        }
    }

    public void guardarHistorialEnArchivo(String nombreArchivo) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            salida.writeObject(this);
            System.out.println("Historial guardo en archivo exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar el historial en el archivo: " + e.getMessage());
        }
    }

    public static Hospital cargarHistorialDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (Hospital) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar el historial desde el archivo: " + e.getMessage());
            return null;
        }
    }
}
    abstract class Persona {
        private String nombre;

        private int dni;
        private Date fechaDeNacimiento;

        public Persona(String nombre, int dni, Date fechaDeNacimiento) {
            this.nombre = nombre;
            this.dni = dni;
            this.fechaDeNacimiento = fechaDeNacimiento;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getDni() {
            return dni;
        }

        public void setDni(int dni) {
            this.dni = dni;
        }

        public Date getFechaDeNacimiento() {
            return fechaDeNacimiento;
        }

        public void setFechaDeNacimiento(Date fechaDeNacimiento) {
            this.fechaDeNacimiento = fechaDeNacimiento;
        }

        public abstract void mostrarInformacion();
    }

    class Doctor extends Persona {
        private String especialidad;
        @Override
        public void mostrarInformacion{
            System.out.println("Nombre del Doctor:" + super.getNombre());
            System.out.println("Especialidad:" + especialidad);
        }
    }

    class Paciente extends Persona implements Informacion {
        public Paciente(List<String> historialMedico) {
            this.historialMedico = historialMedico;
        }

        public Paciente(String nombre, int dni, Date fechaDeNacimiento, int numeroDeTelefono, int tipoDeSangre, List<String> historialMedico) {
            super(nombre, dni, fechaDeNacimiento);
            this.numeroDeTelefono = numeroDeTelefono;
            this.tipoDeSangre = tipoDeSangre;
            this.historialMedico = historialMedico;
        }

        private int numeroDeTelefono;
        private int tipoDeSangre;
        private List<String> historialMedico;

        @Override
        public void verHistorialDeEventos() {
            for (String historial : historialMedico) {
                System.out.println(historial);
            }
        }

        @Override
        public void mostrarInformacion() {
            System.out.println("Nombre del Paciente:" + super.getNombre());
            System.out.println("numero de telefono:" + numeroDeTelefono);
        }
    }

    interface Informacion {
        public void verHistorialDeEventos();
    }