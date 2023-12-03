package org.GrupoNavarro;

import java.util.ArrayList;
import java.util.List;
//Final para que no se pueda heredar de especialidad
public final class Especialidad {
    private String codigo;
    private String nombre;

    public Especialidad(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Especialidad() {
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

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

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

    public static void imprimirEspecialidades() {
        System.out.println("Lista de Especialidades: \n");

        for (Especialidad especialidad : especialidades) {
            System.out.println("Codigo: " + especialidad.getCodigo());
            System.out.println("Tipo: " + especialidad.getNombre());
        }
    }

}
