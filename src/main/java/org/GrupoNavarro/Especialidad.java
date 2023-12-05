package org.GrupoNavarro;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//Final para que no se pueda heredar de especialidad
public final class Especialidad {
    private String codigo;
    private String nombre;

    public Especialidad(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    private static List<Especialidad> especialidades = new ArrayList<>();

    static {
        // Crear las especialidades
        Especialidad electricidad = new Especialidad("ELE","Electricidad");
        Especialidad seguridad = new Especialidad("SEG","Seguridad");
        Especialidad telecomunicaciones = new Especialidad("TEL","Telecomunicaciones");

        especialidades.add(electricidad);
        especialidades.add(seguridad);
        especialidades.add(telecomunicaciones);
    }
    public static Especialidad obtenerEspecialidad(String nombreEspecialidad) {

        Especialidad especialidad = null;

        // Buscar la especialidad en la lista de especialidades
        for (Especialidad e : Especialidad.especialidades) {
            if (e.getNombre().equals(nombreEspecialidad)) {
                especialidad = e;
                break;
            }
        }
        // Si no se encuentra la especialidad, crear una nueva
        if (especialidad == null) {
            especialidad = new Especialidad("", nombreEspecialidad);
        }
        return especialidad;
    }
    public static void crearEspecialidad() {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        // Solicitar el nombre de la especialidad
        System.out.print("Ingrese el nombre de la especialidad: ");
        String nombre = scanner.nextLine();

        // Solicitar el código de la especialidad
        System.out.print("Ingrese el código de la especialidad: ");
        String codigo = scanner.nextLine();

        // Validar los datos
        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }
        if (codigo.isEmpty()) {
            System.out.println("El código no puede estar vacío.");
            return;
        }

        // Crear la especialidad
        Especialidad especialidad = new Especialidad(codigo, nombre);
        especialidades.add(especialidad);
        // Imprimir la especialidad
        System.out.println(especialidad.getNombre() + " (" + especialidad.getCodigo() + ")");
    }
    public static void listarEspecialidades() {
        // Imprimir las especialidades
        for (Especialidad especialidad : especialidades) {
            System.out.println(especialidad.getNombre() + " (" + especialidad.getCodigo() + ")");
        }
    }

}
