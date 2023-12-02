package org.GrupoNavarro;

import java.util.ArrayList;
import java.util.List;

public class Especialidad {
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
        Especialidad electricidad = new Especialidad("01","Electricidad");
        Especialidad seguridad = new Especialidad("02","Seguridad");
        Especialidad telecomunicaciones = new Especialidad("03","Telecomunicaciones");

        especialidades.add(electricidad);
        especialidades.add(seguridad);
        especialidades.add(telecomunicaciones);
    }
   public String ObtenerCodigoPorNombreEspecialidad(String nombreEspecialidad){
        nombreEspecialidad = nombreEspecialidad.trim().toLowerCase();
        for (Especialidad e : especialidades) {
            if (e.getNombre().trim().toLowerCase().equals(nombreEspecialidad)) {
                return e.getCodigo();
            }
        }
        return null;
    }
}
