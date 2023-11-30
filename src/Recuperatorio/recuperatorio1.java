package Recuperatorio;

import java.io.*;
import  java.util.*;

public class recuperatorio1 {
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        GestorUniversidad gestorUniversidad= new GestorUniversidad();
        int x;

        do {
            System.out.println("Menú:\n" +
                    "1. Listar Profesores.\n" +
                    "2. Listar Estudiantes.\n" +
                    "3. Listar Materias.\n" +
                    "4. Registrar un nuevo profesor.\n" +
                    "5. Registrar un nuevo estudiante.\n" +
                    "6. Asignar profesor a materia.\n" +
                    "7. Inscribir estudiante a materia.\n" +
                    "8. Guardar Información en Archivo.\n" +
                    "9. Cargar Información desde Archivo.\n" +
                    "10. Salir.");
            System.out.print("Ingrese su opción: ");
            x = teclado.nextInt();

            switch (x) {
                case 1:
                    gestorUniversidad.listarProfesores();
                    break;
                case 2:
                    gestorUniversidad.listarEstudiantes();
                    break;
                case 3:
                    gestorUniversidad.listarMaterias();
                    break;
                case 4:
                    gestorUniversidad.registrarProfesor(teclado);
                    break;
                case 5:
                    gestorUniversidad.registrarEstudiante(teclado);
                    break;
                case 6:
                    gestorUniversidad.asignarProfesorAMateria(teclado);
                    break;
                case 7:
                    gestorUniversidad.inscribirEstudianteAMateria(teclado);
                    break;
                case 8:
                    gestorUniversidad.guardarInformacionEnArchivo(teclado);
                    break;
                case 9:
                    gestorUniversidad = GestorUniversidad.cargarInformacionDesdeArchivo(teclado);
                    break;
                case 10:
                    System.out.println("Saliendo. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }


        }while (x!=10);


    }
}

class GestorUniversidad implements Serializable {

    private ArrayList<Profesor> profesores= new ArrayList<>();
    private ArrayList<Estudiante> estudiantes= new ArrayList<>();
    private ArrayList<Materia> materias= new ArrayList<>();

    public void listarProfesores(){
        System.out.println("Listado de profesores: ");
        for (Profesor profesor: profesores) {
            System.out.println(profesor);
        }
    }
    public void listarEstudiantes(){
        System.out.println("Listado de estudiantes: ");
        for (Estudiante estudiante: estudiantes) {
            System.out.println(estudiante);
        }
    }
    public void listarMaterias(){
        System.out.println("Listado de materias: ");

        for (Materia materia: materias) {
            System.out.println(materia);
        }
    }

    public void agregarMateria(Scanner teclado){
        System.out.println("Ingrese el nombre de la materia");
        String nombreMateria = teclado.next();
        Materia materia= new Materia(nombreMateria);
        materias.add(materia);
    }

    public void registrarProfesor(Scanner teclado){
        System.out.println("Ingrese el nombre del profesor");
        String nombre = teclado.next();
        System.out.println("Ingrese el dni del profesor");
        String dni = teclado.next();
        System.out.println("Ingrese la fecha de nacimiento del profesor");
        String fechaDeNacimiento = teclado.next();
        System.out.println("Ingrese la especialidad del profesor");
        String especialidad = teclado.next();

        Profesor profesor= new Profesor(nombre,dni,fechaDeNacimiento,especialidad);
        profesores.add(profesor);
    }
    public void registrarEstudiante(Scanner teclado){
        System.out.println("Ingrese el nombre del estudiante");
        String nombre = teclado.next();
        System.out.println("Ingrese el dni del estudiante");
        String dni = teclado.next();
        System.out.println("Ingrese la fecha de nacimiento del estudiante");
        String fechaDeNacimiento = teclado.next();

        Estudiante estudiante= new Estudiante(nombre,dni,fechaDeNacimiento);
        estudiantes.add(estudiante);
    }

    public void asignarProfesorAMateria(Scanner teclado){
        System.out.println("Ingrese el nombre de la materia");
        String nombreMateria= teclado.next();
        System.out.println("Ingrese el dni del profesor a cargo de la materia");
        String profesorACargo= teclado.next();


        for (Materia materia: materias) {
            if (nombreMateria.equals(materia.getNombreMateria())){
                for (Profesor profesor: profesores) {
                    if (profesorACargo.equals(profesor.getDni())){
                        materia.setProfesorACargo(profesorACargo);
                        System.out.println("Asignación exitosa");
                    }
                }
            }
        }
    }

    public void inscribirEstudianteAMateria(Scanner teclado){
        System.out.println("Ingrese el nombre de la materia");
        String nombreMateria= teclado.next();
        System.out.println("Ingrese el dni del estudiante a inscribir");
        String dni= teclado.next();


        for (Materia materia: materias) {
            if (nombreMateria.equals(materia.getNombreMateria())){
                for (Estudiante estudiante: estudiantes) {
                    if (dni.equals(estudiante.getDni())){
                        materia.getEstudiantes().add(estudiante);
                        System.out.println("Inscripción exitosa");
                    }
                }
            }
        }
    }

    public void guardarInformacionEnArchivo(Scanner teclado) {
        System.out.println("Ingrese el nombre deseado para el archivo");
        String nombreArchivo= teclado.next();
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            salida.writeObject(this);
            System.out.println("Información guardada en archivo exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar la información en el archivo: " + e.getMessage());
        }
    }

    public static GestorUniversidad cargarInformacionDesdeArchivo(Scanner teclado) {
        System.out.println("Ingrese el nombre del archivo");
        String nombreArchivo= teclado.next();
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (GestorUniversidad) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar la informacion desde el archivo: " + e.getMessage());
            return null;
        }
    }
}

abstract class Persona {
    private String nombre;
    private String dni;
    private String fechaDeNacimiento;

    public Persona(String nombre, String dni, String fechaDeNacimiento) {
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
}

class Profesor extends Persona{
    private String especialidad;

    public Profesor(String nombre, String dni, String fechaDeNacimiento, String especialidad) {
        super(nombre, dni, fechaDeNacimiento);
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Recuperatorio.Profesor{" +
                "nombre='" + super.getNombre() + '\'' +
                "dni='" + super.getDni() + '\'' +
                "fecha de nacimiento='" + super.getFechaDeNacimiento() + '\'' +
                "especialidad='" + especialidad + '\'' +
                '}';
    }
}

class Estudiante extends Persona{

    public Estudiante(String nombre, String dni, String fechaDeNacimiento) {
        super(nombre, dni, fechaDeNacimiento);
    }

    @Override
    public String toString() {
        return "Recuperatorio.Estudiante{" +
                "nombre='" + super.getNombre() + '\'' +
                "dni='" + super.getDni() + '\'' +
                "fecha de nacimiento='" + super.getFechaDeNacimiento() + '\'' +
                '}';
    }
}

class Materia {

    private String nombreMateria;
    private String profesorACargo;
    private ArrayList<Estudiante> estudiantes= new ArrayList<>();

    public Materia(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }
    public Materia(String nombreMateria, String profesorACargo, ArrayList<Estudiante> estudiantes) {
        this.nombreMateria = nombreMateria;
        this.profesorACargo = profesorACargo;
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Recuperatorio.Materia{" +
                "nombreMateria='" + nombreMateria + '\'' +
                ", profesorACargo='" + profesorACargo + '\'' +
                ", estudiantes=" + estudiantes +
                '}';
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getProfesorACargo() {
        return profesorACargo;
    }

    public void setProfesorACargo(String profesorACargo) {
        this.profesorACargo = profesorACargo;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
